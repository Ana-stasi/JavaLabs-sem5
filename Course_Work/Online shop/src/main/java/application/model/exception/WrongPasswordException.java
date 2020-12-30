package application.model.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(){
        super("label.wrong.password");
    }
    public WrongPasswordException(String message){
        super(message);
    }
}
