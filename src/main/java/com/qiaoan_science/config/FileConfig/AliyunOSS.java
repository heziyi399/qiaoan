package com.qiaoan_science.config.FileConfig;

import lombok.Data;

/**
 * @author hzy
 * @date 2022-04-10
 */
@Data
public class AliyunOSS {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String objectName;
    private String domain;
}
