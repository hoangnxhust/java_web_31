import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputFile = "data.txt";
        String outputDir = "images/";
        ImageDownloader downloader = new ImageDownloader();
        try {
            // Đọc danh sách link ảnh từ file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                // Tải về ảnh và lưu vào thư mục images với tên tương ứng
                downloader.downloadImage(line, outputDir);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}