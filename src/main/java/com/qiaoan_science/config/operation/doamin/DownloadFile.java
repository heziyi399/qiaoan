package com.qiaoan_science.config.operation.doamin;

import lombok.Data;

/**
 * @author hzy
 * @date 2022-04-10
 */

@Data
public class DownloadFile {
    private String fileUrl;
    private long fileSize;
//    private String timeStampName;
}
