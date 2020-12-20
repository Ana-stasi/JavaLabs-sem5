package lab3.model.service.exceptions;

public class NoOrderException extends RuntimeException{
    public NoOrderException(){
        super("You haven't made any order");
    }
    public NoOrderException(String message){
        super(message);
    }
}
