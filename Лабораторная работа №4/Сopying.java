import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Сopying {
    public static void main(String[] args) {
        
        copyFile("test/file.txt", "test/copiedFiles/copiedTextFile.txt");
    }

    public static void copyFile(String source, String destination) {
 
        FileInputStream input = null;
        FileOutputStream output = null;
        
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(destination);
        } catch (IOException e) {
            System.out.println("Error: произошла ошибка при открытии файлов - " + e.getMessage() );
        }

        try {    
            byte[] buffer = new byte[65536];

            while (input.available() > 0) {
                int length = input.read(buffer);
                input.close();
                output.write(buffer, 0, length); 
            }
            System.out.println("Copied the file successfully");

        } catch (IOException e) {

            System.out.println("Error: произошла ошибка при копировании файла - " + e.getMessage());

        } finally {

            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }

            } catch (IOException e) {
                System.out.println("Error: произошла ошибка при закрытии файлов - " + e.getMessage());
            }
        }
    }
}

