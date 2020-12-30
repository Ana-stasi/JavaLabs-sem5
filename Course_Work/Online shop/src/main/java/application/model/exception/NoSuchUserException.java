package application.model.exception;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException(){
        super("no.such.user");
    }
    public NoSuchUserException(String message){
        super(message);
    }
}
