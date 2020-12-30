package application.model.exception;

public class UnsupportedUsernameException extends RuntimeException{
    public UnsupportedUsernameException(){
        super("label.unsupported_username");
    }
    public UnsupportedUsernameException(String message) {
        super(message);
    }
}
