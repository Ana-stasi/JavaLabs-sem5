package application.model.exception;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(){
        super("label.no_such_product");
    }
    public NoSuchProductException(String message){
        super(message);
    }
}
