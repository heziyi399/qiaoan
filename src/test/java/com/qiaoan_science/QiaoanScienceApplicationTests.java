package com.qiaoan_science;

import com.qiaoan_science.config.FileConfig.HeziyiAliyunOSSDownloader;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class QiaoanScienceApplicationTests {
@Autowired
private HeziyiAliyunOSSDownloader download;
    @Test
    void contextLoads() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        String word = "nice";
        String address = "https://dict.iciba.com/dictionary/word/suggestion?" +
                "word="+word+"&nums=5&ck=709a0db45332167b0e2ce1868b84773e&timestamp=1649942155199&client=6&uid=123123&key=1000006" +
                "&is_need_mean=1&signature=a7b4565d4a71f2efa3cf5bf314219078";
        Request request = new Request.Builder()
                .url(address)
                .method("GET", null)
                .addHeader("apikey", "hDO92JGwoXICHP7YX2PJvRaB1A7y0G")
                .build();
        Response response = client.newCall(request).execute();
        Headers responseHeaders = response.headers();
//        for (int i = 0; i < responseHeaders.size(); i++) {
//            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//        }
String res = response.body().string();
 int begin = res.indexOf("paraphrase");
 int end = res.indexOf("value");
        System.out.println(res.substring(begin+13, end-3));
      //  System.out.println(response.body().string());
    }

}
