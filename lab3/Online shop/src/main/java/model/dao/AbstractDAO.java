package lab3.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO<K,E> implements BaseDAO<K,E> {
    protected ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
    protected Connection connection;

public void closeConnection() throws SQLException {
    connection.close();
}
}
