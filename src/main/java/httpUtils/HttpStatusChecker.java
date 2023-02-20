package httpUtils;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;



public class HttpStatusChecker {
   public static String getStatusImage(int code){
        Connection.Response response = null;
        String url = "https://http.cat/"+code;
        try {
            int statusCode = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(1000)
                    .execute()
                    .statusCode();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return url;
    }
}
