package httpUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    int code;
    void askStatus(){
        System.out.println("Enter HTTP status code");
        try(Scanner scanner = new Scanner(System.in)) {
            code = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Please enter valid number");
        }
try {
    new HttpStatusImageDownloader().downloadStatusImage(code);
} catch (RuntimeException e){
    System.out.println("There is not image for HTTP status "+code);
}
    }
}
