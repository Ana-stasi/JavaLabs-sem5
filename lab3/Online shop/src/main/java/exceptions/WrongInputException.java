package exceptions;

public class WrongInputException extends RuntimeException {
    public WrongInputException(){
        super("Wrong input :( Enter only numbers without space");
    }
    public WrongInputException(String message) {
        super(message);
    }
}
