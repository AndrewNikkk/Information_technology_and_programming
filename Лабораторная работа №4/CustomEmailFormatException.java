public class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException() {

    }

    public CustomEmailFormatException(String message) {
        super(message);
    }

    public CustomEmailFormatException(String message, Throwable cause) {
        super(message, cause); 
    }

    public CustomEmailFormatException(Throwable cause) {
        super(cause);
    }

    public CustomEmailFormatException(String message, Throwable cause, boolean enableSupperession, boolean writableStackTrace) {
        super(message, cause, enableSupperession, writableStackTrace);
    }
}

