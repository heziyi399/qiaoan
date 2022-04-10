package com.qiaoan_science.config.autoconfiguration;

import com.qiaoan_science.config.FileConfig.AliyunConfig;
import com.qiaoan_science.config.FileConfig.UFOProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hzy
 * @date 2022-04-10
 */

@Slf4j
@Configuration
//@ConditionalOnClass(UFOService.class)
@EnableConfigurationProperties({UFOProperties.class})
public class UFOAutoConfiguration {
    public static String localStoragePath;
    public static AliyunConfig aliyunConfig;

    @Bean
    public MyUFOFactory ufoFactory(UFOProperties ufoProperties) {
        localStoragePath = ufoProperties.getLocalStoragePath();
        aliyunConfig = ufoProperties.getAliyun();
        return new MyUFOFactory(ufoProperties.getStorageType());
    }





}
