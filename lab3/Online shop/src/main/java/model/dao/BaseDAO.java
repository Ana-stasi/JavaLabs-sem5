package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDAO<K,E> implements AbstractDAO <K,E> {
    protected ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
    protected Connection connection;

public void close() throws SQLException {
    connection.close();
}
}
