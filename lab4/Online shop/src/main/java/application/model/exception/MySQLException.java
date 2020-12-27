package application.model.exception;

import java.sql.SQLException;

public class MySQLException extends SQLException {
    public MySQLException(){
        super("Sorry, something went wrong.We're working on getting this fixed as soon as we can.");
    }
}
