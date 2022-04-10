package com.qiaoan_science.Exception;

/**
 * @author hzy
 * @date 2022-04-10
 */
public class UploadException extends RuntimeException{
    public UploadException(Throwable cause) {
        super("上传出现了异常", cause);
    }

    public UploadException(String message) {
        super(message);
    }

    public UploadException(String message, Throwable cause) {
        super(message, cause);
    }

}
