package com.qiaoan_science.config.FileConfig;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.qiaoan_science.config.autoconfiguration.UFOAutoConfiguration;
import com.qiaoan_science.config.operation.AbstractClass.Deleter;
import com.qiaoan_science.config.operation.doamin.DeleteFile;

import org.springframework.stereotype.Component;

/**
 * @author hzy
 * @date 2022-04-02
 */
@Component
public class HeziyiAliyunOSSDeleter extends Deleter {

    @Override
    public void delete(DeleteFile deleteFile) {
        String endpoint = UFOAutoConfiguration.aliyunConfig.getOss().getEndpoint();
        String accessKeyId = UFOAutoConfiguration.aliyunConfig.getOss().getAccessKeyId();
        String accessKeySecret = UFOAutoConfiguration.aliyunConfig.getOss().getAccessKeySecret();
        String bucketName = UFOAutoConfiguration.aliyunConfig.getOss().getBucketName();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        ossClient.deleteObject(bucketName, deleteFile.getFileUrl().substring(1));



        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
