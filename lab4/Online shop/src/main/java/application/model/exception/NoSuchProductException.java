package application.model.exception;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(){
        super("Product with such № doesn't exist");
    }
    public NoSuchProductException(String message){
        super(message);
    }
}
