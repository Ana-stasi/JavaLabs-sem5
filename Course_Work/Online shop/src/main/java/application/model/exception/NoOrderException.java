package application.model.exception;

public class NoOrderException extends RuntimeException{
    public NoOrderException(){
        super("label.no_order");
    }
    public NoOrderException(String message){
        super(message);
    }
}
