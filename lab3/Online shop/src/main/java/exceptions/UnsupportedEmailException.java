package exceptions;

public class UnsupportedEmailException extends RuntimeException {
    public UnsupportedEmailException(){
        super("Unsupported email");
    }
    public UnsupportedEmailException(String message){
        super(message);
    }
}
