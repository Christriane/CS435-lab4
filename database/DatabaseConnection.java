package database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {

    void startConnection();
    Connection getConnection();
    void closeConnection() throws SQLException;

}

