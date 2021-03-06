package com.qiaoan_science.util;

import com.qiaoan_science.config.autoconfiguration.UFOAutoConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author hzy
 * @date 2022-04-10
 */

public class PathUtil {

    /**
     * 获取项目所在的根目录路径 resources路径
     * @return
     */
    public static String getProjectRootPath() {
        String absolutePath = null;
        try {
            String url = ResourceUtils.getURL("classpath:").getPath();
            absolutePath = urlDecode(new File(url).getAbsolutePath()) + File.separator;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return absolutePath;
    }

    /**
     * 路径解码
     * @param url
     * @return
     */
    public static String urlDecode(String url){
        String decodeUrl = null;
        try {
            decodeUrl = URLDecoder.decode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  decodeUrl;
    }

    /**
     * 得到static路径
     *
     * @return
     */
    public static String getStaticPath() {
        String localStoragePath = UFOAutoConfiguration.localStoragePath;//PropertiesUtil.getProperty("qiwen-file.local-storage-path")
        if (StringUtils.isNotEmpty(localStoragePath)) {
            return localStoragePath;
        }else {
            String projectRootAbsolutePath = getProjectRootPath();

            int index = projectRootAbsolutePath.indexOf("file:");
            if (index != -1) {
                projectRootAbsolutePath = projectRootAbsolutePath.substring(0, index);
            }

            return projectRootAbsolutePath + "static" + File.separator;
        }


    }


    public static String getParentPath(String path) {
        return path.substring(0, path.lastIndexOf( "/"));
    }

}
