package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlQueries {
    private Connection connection;

    public SqlQueries(Connection connection){
        this.connection = connection;
    }

    //query one
    public ResultSet displaySchedule(String startLocationName, String destinationName, String date) throws SQLException {

        //build query string
        String sql = "SELECT T2.ScheduledStartTime, T2.ScheduledArrivalTime, T2.DriverName, T2.BusID " +
                "FROM TripOffering T2, Trip T " +
                "WHERE T.TripNumber = T2.TripNumber AND  T.StartLocationName = ? AND T.DestinationName = ? AND T2.Date = ?";

        //add user input to string
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setString(1, startLocationName);
        myStmt.setString(2, destinationName);
        myStmt.setString(3, date);

        //execute query
        ResultSet resultSet = myStmt.executeQuery();

        //return query results
        return resultSet;
    }

    //query 2.a
    public int deleteTrip(String tripNumber, String date, String scheduleStartTime) throws SQLException {

        //build query string
        String sql = "DELETE FROM TripOffering\n" +
                "WHERE TripNumber = ? AND Date = ? AND ScheduledStartTime = ?";

        //add user input to string
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setString(1, tripNumber);
        myStmt.setString(2, date);
        myStmt.setString(3, scheduleStartTime);

        //execute query
        int resultSet = myStmt.executeUpdate();

        //return query results
        return resultSet;
    }

    //query 2.b
    public ResultSet addTrip(){
        return null;
    }

    //query 2.c
    public ResultSet changeDriver(){
        return null;
    }

    //query 2.d
    public ResultSet changeBus(){
        return null;
    }
}
