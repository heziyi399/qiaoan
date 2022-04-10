package com.qiaoan_science.config.operation.AbstractClass;

import com.qiaoan_science.config.operation.doamin.DownloadFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author hzy
 * @date 2022-04-10
 */
public abstract class Downloader {
    public abstract void download(HttpServletResponse httpServletResponse, DownloadFile uploadFile);
    public abstract InputStream getInputStream(DownloadFile downloadFile);
}
