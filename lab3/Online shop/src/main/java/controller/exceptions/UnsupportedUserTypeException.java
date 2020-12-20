package lab3.controller.exceptions;

public class UnsupportedUserTypeException extends Exception{
    public UnsupportedUserTypeException(){
        super("Please, type 'admin' or 'user'!");
    }

    public UnsupportedUserTypeException(String message) {
        super(message);
    }
}
