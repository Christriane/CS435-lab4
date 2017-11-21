package database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {

    void startConnection();
    void createTables() throws SQLException;
    void insertDataIntoTables() throws SQLException;
    Connection getConnection();

}

