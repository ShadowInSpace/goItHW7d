package httpUtils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;


import java.io.FileOutputStream;
import java.io.IOException;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) {
        String imageUrl = HttpStatusChecker.getStatusImage(code);
        String destinationFile = "StatusCode"+code+".jpg";
        try (FileOutputStream out = new FileOutputStream(destinationFile)) {
            Connection.Response resultImageResponse = Jsoup.connect(imageUrl)
                    .ignoreContentType(true)
                    .execute();
            out.write(resultImageResponse.bodyAsBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
