package com.qiaoan_science;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

@SpringBootApplication
@MapperScan("com.qiaoan_science")
public class QiaoanScienceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QiaoanScienceApplication.class, args);
    }

}
