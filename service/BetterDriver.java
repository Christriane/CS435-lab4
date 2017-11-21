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

//        //create tables - only run once
//        //add checks later
//        mySQLConnection.createTables();
//
//        //populate tables - only run once
//        //add checks later
//        mySQLConnection.insertDataIntoTables();

        //run queries
        SqlQueries sqlQueries = new SqlQueries(connection);

        // query 1
        // displayResults.display(sqlQueries.displaySchedule("Pomona", "Walnut", "1-1-2001"));

        // query 2.a
        //displayResults.displayTwo(sqlQueries.deleteTrip("Trip1","1-1-2001","MON 10:00AM"));

        //query 2.b
        //Can't add due to foreign key constraint
        //displayResults.displayThree(sqlQueries.addTrip("Trip100","11-21-2017","MON 10:55AM","MON 12:00PM","Bob","Bus100"));

        //query 2.c
        //Can't add due to foreign key constraint
        //displayResults.displayFour(sqlQueries.changeDriver("Liouse","Trip10","1-10-2001","SUN 10:00AM"));

        //query 2.d
        //Can't change due to foreign key constraint
        //displayResults.displayFour(sqlQueries.changeBus("CoolBus8","Trip8","1-8-2001","SAT 10:00AM"));

        //query 3
        //displayResults.displayFive(sqlQueries.displayStops());

        //query 4
        //weird output???
        //displayResults.displaySix(sqlQueries.displayWeeklySchedule("Driver7","1-7-2001"));

        //query 5
        //says can't insert but still works, status code flipped? use execute to check with boolean instead..
        //displayResults.displayThree(sqlQueries.addDriver("jam","909-999-8888"));

        //query 6
        //says can't insert but still works, status code flipped? use execute to check with boolean instead..
        //displayResults.displayThree((sqlQueries.addBus("Bus999","Tesla","2020")));

        //query 7
        //says can't insert but still works, status code flipped? use execute to check with boolean instead..
        //displayResults.displayTwo(sqlQueries.deleteBus("Bus999"));

        //query 8
        //Can't change due to foreign key constraint
        displayResults.displayThree(sqlQueries.addActualTrip("1","1","1","1","1","1","1", "1", "1"));
    }
}
