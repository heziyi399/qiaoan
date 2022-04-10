package com.qiaoan_science.config.operation.doamin;

import lombok.Data;

/**
 * @author hzy
 * @date 2022-04-10
 */

@Data
public class UploadFile {
    private String fileName;
    private String fileType;
    private long fileSize;
    private String timeStampName;
    private int success;
    private String message;
    private String url;
    private Integer storageType;
    //切片上传相关参数
    private String taskId;
    private int chunkNumber;
    private long chunkSize;
    private int totalChunks;
    private String identifier;
    private long totalSize;
    private long currentChunkSize;


}
