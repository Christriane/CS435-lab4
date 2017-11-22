package database;

import java.sql.*;

public class MySQLConnection implements DatabaseConnection {

    //Singleton pattern applied. Allow only one connection to DB
    private static MySQLConnection instance = null;
    private Connection connection;

    private MySQLConnection(){
    }

    public static MySQLConnection getInstance(){
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    @Override
    public void startConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4?allowMultiQueries=true", "root", "root");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection(){
        return connection;
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }


}
