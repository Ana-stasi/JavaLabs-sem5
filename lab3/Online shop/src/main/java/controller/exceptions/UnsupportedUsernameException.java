package lab3.controller.exceptions;

public class UnsupportedUsernameException extends RuntimeException{
    public UnsupportedUsernameException(){
        super("Unsupported username");
    }
    public UnsupportedUsernameException(String message) {
        super();
    }
}
