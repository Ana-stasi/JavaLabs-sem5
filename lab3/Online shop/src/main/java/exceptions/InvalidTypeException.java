package exceptions;

public class InvalidTypeException extends RuntimeException {
    public InvalidTypeException(){
        super("Invalid type");
    }
    public InvalidTypeException(String message){
        super(message);
    }
}
