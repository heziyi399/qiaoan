package com.qiaoan_science.config.FileConfig;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CopyObjectResult;
import com.aliyun.oss.model.ObjectMetadata;

import com.qiaoan_science.config.operation.AbstractClass.Renamer;
import com.qiaoan_science.config.operation.doamin.RenameFile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hzy
 * @date 2022-04-02
 */
@Component

public class HeziyiAliyunOSSRenamer extends Renamer {
    @Resource
    UFOProperties ufoProperties;

    @Override
    public void rename(RenameFile renameFile) {
        String endpoint = ufoProperties.getAliyun().getOss().getEndpoint();
        String accessKeyId = ufoProperties.getAliyun().getOss().getAccessKeyId();
        String accessKeySecret = ufoProperties.getAliyun().getOss().getAccessKeySecret();
        String bucketName = ufoProperties.getAliyun().getOss().getBucketName();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        CopyObjectResult result = ossClient.copyObject(bucketName, renameFile.getSrcName(), bucketName, renameFile.getDestName());

        ossClient.deleteObject(bucketName, renameFile.getSrcName());
        ObjectMetadata metadata = new ObjectMetadata();
//        if ("pdf".equals(FileUtil.getFileType(objectName))) {
//            metadata.setContentDisposition("attachment");
//        }

//        ossClient.putObject(bucketName, objectName, inputStream, metadata);


        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
