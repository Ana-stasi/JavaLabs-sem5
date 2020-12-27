package application.model.dao;


import application.model.exception.MySQLException;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO<K, E, D> implements BaseDAO<K, E, D> {
    protected NewConnectionPool connectionPool;
    {
        try {
            connectionPool = NewConnectionPool.getConnectionPool();
        } catch (SQLException e) {
            throw new MySQLException();
        }
    }
    protected Connection connection;

    protected AbstractDAO() throws MySQLException{
        this.connection = connectionPool.getConnection();
    }

    public void closeConnection() {
        connectionPool.closeConnection(connection);
    }
}
