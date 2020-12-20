package lab3.controller.exceptions;

public class BlockedUserException extends RuntimeException {
    public BlockedUserException(){
        super("Your account is blocked");
    }
    public BlockedUserException(String message){
        super(message);
    }
}
