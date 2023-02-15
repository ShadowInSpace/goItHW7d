package httpUtils;


import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Jsoup.connect;

public class HttpStatusChecker {
    String getStatusImage(int code){
        Connection.Response response = null;
        try {
            response = Jsoup.connect("https://http.cat/"+code).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int statusCode = response.statusCode();

    }
}
