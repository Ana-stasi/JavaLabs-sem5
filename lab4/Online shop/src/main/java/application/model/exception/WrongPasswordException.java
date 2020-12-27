package application.model.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(){
        super("Password doesn`t match");
    }
    public WrongPasswordException(String message){
        super(message);
    }
}
