import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

class ExceptionLogger {
    private static final String LOG_FILE = "exceptions.log";

    public static void logException(Exception e) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
                pw.println(LocalDateTime.now() + " - " + e.getClass().getName() + ": " + e.getMessage());
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в лог");
        }
    }
}