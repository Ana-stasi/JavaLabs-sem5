package application.model.exception;

public class BlockedUserException extends RuntimeException {
    public BlockedUserException(){
        super("Your account is blocked");
    }
    public BlockedUserException(String message){
        super(message);
    }
}
