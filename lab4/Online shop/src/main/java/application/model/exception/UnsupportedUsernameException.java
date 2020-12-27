package application.model.exception;

public class UnsupportedUsernameException extends RuntimeException{
    public UnsupportedUsernameException(){
        super("Unsupported username");
    }
    public UnsupportedUsernameException(String message) {
        super(message);
    }
}
