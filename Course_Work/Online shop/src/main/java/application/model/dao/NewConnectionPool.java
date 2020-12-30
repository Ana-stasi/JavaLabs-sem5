package application.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewConnectionPool {
    private static NewConnectionPool newConnectionPool;
    private static int CONNECTION_POOL_SIZE = 10;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    public static NewConnectionPool getConnectionPool() throws SQLException {
        if (newConnectionPool == null) {
            ResourceBundle resource = ResourceBundle.getBundle("database");
            String url = resource.getString("url");
            String user = resource.getString("user");
            String password = resource.getString("password");

            List<Connection> pool = new ArrayList<>(CONNECTION_POOL_SIZE);
            for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
                pool.add(createConnection(url, user, password));
            }
            newConnectionPool = new NewConnectionPool(url, user, password, pool);
        }
        return newConnectionPool;
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private NewConnectionPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }

    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public void closeConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
