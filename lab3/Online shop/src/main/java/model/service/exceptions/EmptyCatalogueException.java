package lab3.model.service.exceptions;

public class EmptyCatalogueException extends RuntimeException {
    public EmptyCatalogueException(){
        super("Catalogue is empty.");
    }
    public EmptyCatalogueException(String message){
        super(message);
    }
}
