package utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {

    public static File buteToFile(String fileName, byte[] bytes) {
        File file = new File(fileName);
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write(bytes);
        } catch (Exception e) {
            System.out.println("Exeption: " + e.getMessage());
        }
        return file;
    }

}
