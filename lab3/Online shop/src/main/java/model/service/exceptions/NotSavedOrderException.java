package lab3.model.service.exceptions;

public class NotSavedOrderException extends RuntimeException{
    public NotSavedOrderException(){
        super("Your order wasn't saved");
    }
}
