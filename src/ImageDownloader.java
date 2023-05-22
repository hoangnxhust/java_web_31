import java.io.*;
import java.net.URL;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageDownloader {

    public static void downloadImage(String imageUrl, String outputDir) {
        try {
            // Tạo URL từ đường link ảnh
            URL url = new URL(imageUrl);
            // Lấy tên file từ URL
            String fileName = url.getFile();
            fileName = fileName.substring(fileName.lastIndexOf("/") + 1);

            // Tạo đường dẫn đầy đủ cho tập tin đầu ra
            String outputPath = outputDir + fileName;
            Path outputFilePath = Paths.get(outputPath);

            // Tải ảnh từ URL và lưu vào đường dẫn đầu ra
            Files.copy(url.openStream(), outputFilePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Đã tải xuống và lưu " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
