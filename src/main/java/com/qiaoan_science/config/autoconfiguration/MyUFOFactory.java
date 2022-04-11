package com.qiaoan_science.config.autoconfiguration;

import com.qiaoan_science.config.FileConfig.HeziyiAliyunOSSDeleter;
import com.qiaoan_science.config.FileConfig.HeziyiAliyunOSSDownloader;
import com.qiaoan_science.config.FileConfig.HeziyiAliyunOSSRenamer;
import com.qiaoan_science.config.FileConfig.HeziyiAliyunOSSUploader;
import com.qiaoan_science.config.operation.AbstractClass.Downloader;
import com.qiaoan_science.config.operation.AbstractClass.Renamer;
import com.qiaoan_science.config.operation.AbstractClass.Uploader;

import com.qiaoan_science.config.operation.AbstractClass.Deleter;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hzy
 * @date 2022-04-10
 */
//@Component
@Data
public class MyUFOFactory {
    private String storageType;



    public MyUFOFactory() {
    }

    public MyUFOFactory(String storageType) {
        this.storageType = storageType;
    }

    public Uploader getUploader() {


        return new HeziyiAliyunOSSUploader();

    }


    public Downloader getDownloader() {

        return new HeziyiAliyunOSSDownloader();

    }


    public Deleter getDeleter() {

        return new HeziyiAliyunOSSDeleter();

    }

    public Renamer getRenamer() {

        return new HeziyiAliyunOSSRenamer();

    }
}
