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

import javax.annotation.Resource;

/**
 * @author hzy
 * @date 2022-04-10
 */

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


    public Downloader getDownloader(int storageType) {

        return new HeziyiAliyunOSSDownloader();

    }


    public Deleter getDeleter(int storageType) {

        return new HeziyiAliyunOSSDeleter();

    }

    public Renamer getRenamer(int storageType) {

        return new HeziyiAliyunOSSRenamer();

    }
}
