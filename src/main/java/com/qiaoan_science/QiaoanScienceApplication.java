package com.qiaoan_science;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("com.qiaoan_science")
public class QiaoanScienceApplication {
//把项目推到仓库步骤： git remote add origin git@github.com:smfx1314/test2.git
    //git push -u origin master
    public static void main(String[] args) {
        SpringApplication.run(QiaoanScienceApplication.class, args);
    }

}
