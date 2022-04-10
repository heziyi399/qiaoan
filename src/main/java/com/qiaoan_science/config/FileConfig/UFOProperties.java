package com.qiaoan_science.config.FileConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author hzy
 * @date 2022-04-10
 */
@Component
@Data
@ConfigurationProperties(prefix = "ufo")
public class UFOProperties {

    private String storageType;
    private String localStoragePath;
    private AliyunConfig aliyun = new AliyunConfig();
}
