package service;

import database.MySQLConnection;
import database.SqlQueries;
import ui.DisplayResults;
import java.sql.Connection;
import java.sql.SQLException;

public class BetterDriver {

    private static DisplayResults displayResults;
    private static MySQLConnection mySQLConnection;

    public static void main(String[] args) throws SQLException {

        //initialize ui
        displayResults = new DisplayResults();


        //start a connection to database
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        mySQLConnection.startConnection();
        Connection connection = mySQLConnection.getConnection();

        //create tables - only run once
        //add checks later
        //mySQLConnection.createTables();

        //populate tables - only run once
        //add checks later
        //mySQLConnection.insertDataIntoTables();

        //run queries
        SqlQueries sqlQueries = new SqlQueries(connection);

        //query one
        displayResults.display(sqlQueries.displaySchedule("Pomona", "Walnut", "1-1-2001"));
    }
}
