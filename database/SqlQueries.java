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

    //query two
    public ResultSet editSchedule(){
        return null;
    }

    //query three
    public ResultSet deleteTrip(){
        return null;
    }

    //query four
    public ResultSet addTrip(){
        return null;
    }

    //query five
    public ResultSet changeDriver(){
        return null;
    }

    //query six
    public ResultSet changeBus(){
        return null;
    }
}
