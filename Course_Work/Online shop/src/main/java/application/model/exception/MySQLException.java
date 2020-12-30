package application.model.exception;

import java.sql.SQLException;

public class MySQLException extends SQLException {
    public MySQLException(){
        super("label.system_error");
    }
}
