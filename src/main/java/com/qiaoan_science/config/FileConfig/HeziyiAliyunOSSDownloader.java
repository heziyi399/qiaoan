package com.qiaoan_science.config.FileConfig;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.qiaoan_science.config.autoconfiguration.UFOAutoConfiguration;
import com.qiaoan_science.config.operation.AbstractClass.Downloader;

import com.qiaoan_science.config.operation.doamin.DownloadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author hzy
 * @date 2022-04-02
 */
@Component
public class HeziyiAliyunOSSDownloader extends Downloader {

    @Value("${ufo.aliyun.oss.endpoint}")
 public   String endpoint;
    @Value("${ufo.aliyun.oss.access-key-id}")
    public String accessKeyId;
    @Value("${ufo.aliyun.oss.access-key-secret}")
    public String accessKeySecret;
    @Autowired
    private HeziyiAliyunOSSDownloader downloader;
    @Override
    public void download(HttpServletResponse httpServletResponse, DownloadFile downloadFile) {

        BufferedInputStream bis = null;
        byte[] buffer = new byte[1024];

        OSS ossClient = createOSSClient(UFOAutoConfiguration.aliyunConfig.getOss());
        OSSObject ossObject = ossClient.getObject(UFOAutoConfiguration.aliyunConfig.getOss().getBucketName(),
                downloadFile.getFileUrl().substring(1));
        InputStream inputStream = ossObject.getObjectContent();
        try {
            bis = new BufferedInputStream(inputStream);
            OutputStream os = httpServletResponse.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        ossClient.shutdown();
    }

    @Override
    public InputStream getInputStream(DownloadFile downloadFile) {
        OSS ossClient = createOSSClient(UFOAutoConfiguration.aliyunConfig.getOss());
        OSSObject ossObject = ossClient.getObject(UFOAutoConfiguration.aliyunConfig.getOss().getBucketName(),
                downloadFile.getFileUrl().substring(1));
        InputStream inputStream = ossObject.getObjectContent();
        return inputStream;
    }

public OSS createOSSClient(AliyunOSS aliyunOSS) {
String endpoint = downloader.endpoint;
String accessKeyId = downloader.accessKeyId;

String accessKeySecret = downloader.accessKeySecret;
OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
return ossClient;
}
}
