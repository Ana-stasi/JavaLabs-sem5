package application.model.exception;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException(){
        super("Account doesn`t exist");
    }
    public NoSuchUserException(String message){
        super(message);
    }
}
