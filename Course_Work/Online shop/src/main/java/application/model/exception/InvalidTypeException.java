package application.model.exception;

public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(){
        super("label.invalid_type");
    }
    public InvalidTypeException(String message){
        super(message);
    }
}
