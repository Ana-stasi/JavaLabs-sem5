package exceptions;

public class WrongMenuItemException extends RuntimeException {
    public WrongMenuItemException(){
        super("Please, select existing item!");
    }
    public WrongMenuItemException(String message){
        super(message);
    }
}
