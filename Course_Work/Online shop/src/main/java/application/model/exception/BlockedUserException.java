package application.model.exception;

public class BlockedUserException extends RuntimeException {
    public BlockedUserException(){
        super("label.blocked.user");
    }
    public BlockedUserException(String message){
        super(message);
    }
}
