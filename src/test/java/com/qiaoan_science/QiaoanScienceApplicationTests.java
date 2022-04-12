package com.qiaoan_science;

import com.qiaoan_science.config.FileConfig.HeziyiAliyunOSSDownloader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QiaoanScienceApplicationTests {
@Autowired
private HeziyiAliyunOSSDownloader download;
    @Test
    void contextLoads() {
        System.out.println(download.endpoint);
    }

}
