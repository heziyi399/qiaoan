package com.qiaoan_science.config.FileConfig;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.qiaoan_science.Exception.UploadException;
import com.qiaoan_science.config.autoconfiguration.UFOAutoConfiguration;
import com.qiaoan_science.config.operation.AbstractClass.Uploader;

import com.qiaoan_science.config.operation.doamin.UploadFile;
import com.qiaoan_science.util.FileUtil;
import com.qiaoan_science.util.PathUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * @author hzy
 * @date 2022-04-02
 */
@Component
@Slf4j
public class HeziyiAliyunOSSUploader extends Uploader {
    // partETags是PartETag的集合。PartETag由分片的ETag和分片号组成。
    public static Map<String, List<PartETag>> partETagsMap = new HashMap<String, List<PartETag>>();
    public static Map<String, UploadFileInfo> uploadPartRequestMap = new HashMap<>();

    public static Map<String, OSS> ossMap = new HashMap<>();

    @Override
    public List<UploadFile> upload(HttpServletRequest httpServletRequest, UploadFile uploadFile) {
        log.info("开始上传upload");

        List<UploadFile> saveUploadFileList = new ArrayList<>();
        StandardMultipartHttpServletRequest request = (StandardMultipartHttpServletRequest) httpServletRequest;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            throw new UploadException("未包含文件上传域");
        }

        Iterator<String> iter = request.getFileNames();
        while (iter.hasNext()) {

            saveUploadFileList = doUpload(request, iter, uploadFile);
        }


        log.info("结束上传");
        return saveUploadFileList;
    }

    private List<UploadFile> doUpload(StandardMultipartHttpServletRequest standardMultipartHttpServletRequest, Iterator<String> iter, UploadFile uploadFile) {
        String savePath = getLocalFileSavePath();
        OSS ossClient = getClient(uploadFile);

        List<UploadFile> saveUploadFileList = new ArrayList<>();

        try {
            MultipartFile multipartfile = standardMultipartHttpServletRequest.getFile(iter.next());

            String timeStampName = getTimeStampName();
            String originalName = multipartfile.getOriginalFilename();
            String fileName = getFileName(originalName);
            String fileType = FileUtil.getFileExtendName(originalName);
            uploadFile.setFileName(fileName);
            uploadFile.setFileType(fileType);
            uploadFile.setTimeStampName(timeStampName);

            String ossFilePath = savePath + FILE_SEPARATOR + timeStampName + FILE_SEPARATOR + fileName + "." + fileType;
            String confFilePath = savePath + FILE_SEPARATOR + uploadFile.getIdentifier() + "." + "conf";
            File confFile = new File(PathUtil.getStaticPath() + FILE_SEPARATOR + confFilePath);

            synchronized (HeziyiAliyunOSSUploader.class) {
                if (uploadPartRequestMap.get(uploadFile.getIdentifier()) == null) {
                    InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(UFOAutoConfiguration.aliyunConfig.getOss().getBucketName(), ossFilePath.substring(1));
                    InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);
                    String uploadId = upresult.getUploadId();

                    UploadFileInfo uploadPartRequest = new UploadFileInfo();
                    uploadPartRequest.setBucketName("heziyi");
                    uploadPartRequest.setKey(ossFilePath.substring(1));
                    uploadPartRequest.setUploadId(uploadId);
                    uploadPartRequestMap.put(uploadFile.getIdentifier(), uploadPartRequest);
                }

            }

            UploadFileInfo uploadFileInfo = uploadPartRequestMap.get(uploadFile.getIdentifier());
            UploadPartRequest uploadPartRequest = new UploadPartRequest();
            uploadPartRequest.setBucketName(uploadFileInfo.getBucketName());
            uploadPartRequest.setKey(uploadFileInfo.getKey());
            uploadPartRequest.setUploadId(uploadFileInfo.getUploadId());
            uploadPartRequest.setInputStream(multipartfile.getInputStream());
            uploadPartRequest.setPartSize(uploadFile.getCurrentChunkSize());
            uploadPartRequest.setPartNumber(uploadFile.getChunkNumber());
            log.info(JSON.toJSONString(uploadPartRequest));

            UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
            synchronized (HeziyiAliyunOSSUploader.class) {
                log.info("上传结果：" + JSON.toJSONString(uploadPartResult));
                if (partETagsMap.get(uploadFile.getIdentifier()) == null) {
                    List<PartETag> partETags = new ArrayList<PartETag>();
                    partETags.add(uploadPartResult.getPartETag());
                    partETagsMap.put(uploadFile.getIdentifier(), partETags);
                } else {
                    partETagsMap.get(uploadFile.getIdentifier()).add(uploadPartResult.getPartETag());
                }
            }

            boolean isComplete = checkUploadStatus(uploadFile, confFile);
            if (isComplete) {
                log.info("分片上传完成");
                completeMultipartUpload(uploadFile);

                uploadFile.setUrl("/" + uploadPartRequestMap.get(uploadFile.getIdentifier()).getKey());
                uploadFile.setSuccess(1);
                uploadFile.setMessage("上传成功");
                partETagsMap.remove(uploadFile.getIdentifier());
                uploadPartRequestMap.remove(uploadFile.getIdentifier());
                ossMap.remove(uploadFile.getIdentifier());
            } else {
                uploadFile.setSuccess(0);
                uploadFile.setMessage("未完成");
            }

        } catch (Exception e) {
            log.error("上传出错：" + e);
            throw new UploadException(e);
        }

        uploadFile.setStorageType(1);

        uploadFile.setFileSize(uploadFile.getTotalSize());
        saveUploadFileList.add(uploadFile);
        return saveUploadFileList;
    }

    /**
     * 将文件分块进行升序排序并执行文件上传。
     */
    protected void completeMultipartUpload(UploadFile uploadFile) {

        List<PartETag> partETags = partETagsMap.get(uploadFile.getIdentifier());
        Collections.sort(partETags, Comparator.comparingInt(PartETag::getPartNumber));
        UploadFileInfo uploadFileInfo = uploadPartRequestMap.get(uploadFile.getIdentifier());
        CompleteMultipartUploadRequest completeMultipartUploadRequest =
                new CompleteMultipartUploadRequest(UFOAutoConfiguration.aliyunConfig.getOss().getBucketName(),
                        uploadFileInfo.getKey(),
                        uploadFileInfo.getUploadId(),
                        partETags);
        log.info("----:" + JSON.toJSONString(partETags));
        // 完成上传。
        CompleteMultipartUploadResult completeMultipartUploadResult = getClient(uploadFile).completeMultipartUpload(completeMultipartUploadRequest);
        log.info("----:" + JSON.toJSONString(completeMultipartUploadRequest));
        getClient(uploadFile).shutdown();

//
    }


    /**
     * 取消上传
     */
    @Override
    public void cancelUpload(UploadFile uploadFile) {
        AbortMultipartUploadRequest abortMultipartUploadRequest =
                new AbortMultipartUploadRequest(UFOAutoConfiguration.aliyunConfig.getOss().getBucketName(), uploadPartRequestMap.get(uploadFile.getIdentifier()).getKey(), uploadPartRequestMap.get(uploadFile.getIdentifier()).getUploadId());
        getClient(uploadFile).abortMultipartUpload(abortMultipartUploadRequest);
    }

    private synchronized OSS getClient(UploadFile uploadFile) {
        OSS ossClient = null;
        if (ossMap.get(uploadFile.getIdentifier()) == null) {
            ossClient = new OSSClientBuilder().build("https://oss-cn-beijing.aliyuncs.com", "LTAI5tKVCV8sHmKJEJcswyxE",
                   "eRZuJGJlt0wtoopfFCBBM7jCyjI80c");
            ossMap.put(uploadFile.getIdentifier(), ossClient);
        } else {
            ossClient = ossMap.get(uploadFile.getIdentifier());
        }
        return ossClient;
    }

    @Data
    public class UploadFileInfo {
        private String bucketName;
        private String key;
        private String uploadId;
    }

}
