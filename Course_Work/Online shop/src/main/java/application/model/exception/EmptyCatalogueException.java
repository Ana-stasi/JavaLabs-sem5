package application.model.exception;

public class EmptyCatalogueException extends RuntimeException {
    public EmptyCatalogueException(){
        super("label.empty_catalogue");
    }
    public EmptyCatalogueException(String message){
        super(message);
    }
}
