package com.qiaoan_science.Exception;

/**
 * @author hzy
 * @date 2022-04-10
 */
public class DownloadException extends RuntimeException{
    public DownloadException(Throwable cause) {
        super("下载出现了异常", cause);
    }

    public DownloadException(String message) {
        super(message);
    }

    public DownloadException(String message, Throwable cause) {
        super(message, cause);
    }

}
