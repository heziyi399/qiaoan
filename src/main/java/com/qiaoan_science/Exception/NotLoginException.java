package com.qiaoan_science.Exception;

/**
 * @author hzy
 * @date 2022-04-10
 */
public class NotLoginException extends RuntimeException{
    public NotLoginException() {
        super("未登录");
    }
    public NotLoginException(Throwable cause) {
        super("未登录", cause);
    }

    public NotLoginException(String message) {
        super(message);
    }

    public NotLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}