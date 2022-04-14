package com.qiaoan_science.controller;

import com.qiaoan_science.Base.ResponseResult;
import io.swagger.annotations.Api;
import okhttp3.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author hzy
 * @date 2022-04-13
 */
@Api(tags = {"文件上传接口"})
@RestController
@RequestMapping
public class UploadFileController {
    @PostMapping("upload")
    public ResponseResult upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request){
        String fileName = file.getOriginalFilename();

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String random = UUID.randomUUID().toString();

        File dest = new File("D:/myuploadpic" +random+fileName+suffixName);

        try {
            file.transferTo(dest);
        }catch (IOException e) {
            e.printStackTrace();
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("img","/C:/Users/heziyi6/Pictures/src=http___imglf6.nosdn0.126.net_img_KzR3bGJQRmR0K2ZDTDlKNkhkcWRZQUEwNDA1RHVDTFVnYmozek5hL0p4Z3VBRklnYUhjNHBRPT0.jpg_imageView&thumbnail=1680x0&quality=96&stripmeta=0&type=jpg&refer=http___imglf6.nosdn0.126.jpg",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                dest))
                .build();
        Request urlrequest = new Request.Builder()
                .url("http://img.codesocean.top/upload/img")
                .method("POST", body)
                .addHeader("apikey", "hDO92JGwoXICHP7YX2PJvRaB1A7y0G")
                .build();
        try {
            Response response = client.newCall(urlrequest).execute();
            System.out.println(response.body());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return ResponseResult.success("ok");
    }
}
