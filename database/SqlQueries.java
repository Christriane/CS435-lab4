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
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, startLocationName);
        completeQuery.setString(2, destinationName);
        completeQuery.setString(3, date);

        //execute query
        ResultSet resultSet = completeQuery.executeQuery();
        
        //return query results
        return resultSet;
    }

    //query 2.a
    public int deleteTrip(String tripNumber, String date, String scheduleStartTime) throws SQLException {

        //build query string
        String sql = "DELETE FROM TripOffering\n" +
                "WHERE TripNumber = ? AND Date = ? AND ScheduledStartTime = ?";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, tripNumber);
        completeQuery.setString(2, date);
        completeQuery.setString(3, scheduleStartTime);

        //execute query
        int resultSet = completeQuery.executeUpdate();
        
        if(resultSet > 0) {
	        sql = "SELECT * FROM TripOffering";
	        completeQuery = connection.prepareStatement(sql);
	        ResultSet rs = completeQuery.executeQuery();
	        
	        System.out.println("Current Trip Offerings after deletion: ");
	        while(rs.next()) {
	        		System.out.print(rs.getString("TripNumber") + " ");
	        		System.out.print(rs.getString("Date") + " ");
	        		System.out.print(rs.getString("ScheduledStartTime") + " ");
	        		System.out.print(rs.getString("ScheduledArrivalTime") + " ");
	        		System.out.print(rs.getString("DriverName") + " ");
	        		System.out.print(rs.getString("BusID") + "\n");
	        
	        }
    		}
        
        //return query results
        return resultSet;
    }

    //query 2.b
    public int addTrip(String tripNumber, String date, String scheduledStartTime, String scheduledArrivalTime, String driverName, String busID) throws SQLException {
        //build query string
        String sql = "INSERT INTO TripOffering (TripNumber, Date, ScheduledStartTime, ScheduledArrivalTime, DriverName, BusID)\n" +
                "VALUES\n" +
                "(?, ?, ?, ?, ?, ?);";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, tripNumber);
        completeQuery.setString(2, date);
        completeQuery.setString(3, scheduledStartTime);
        completeQuery.setString(4, scheduledArrivalTime);
        completeQuery.setString(5, driverName);
        completeQuery.setString(6, busID);


        //execute query
        int resultSet = completeQuery.executeUpdate();
        
        sql = "SELECT * FROM TripOffering";
        completeQuery = connection.prepareStatement(sql);
        ResultSet rs = completeQuery.executeQuery();
        
        System.out.println("Current Trip Offerings after insertion: ");
        while(rs.next()) {
        		System.out.print(rs.getString("TripNumber") + " ");
        		System.out.print(rs.getString("Date") + " ");
        		System.out.print(rs.getString("ScheduledStartTime") + " ");
        		System.out.print(rs.getString("ScheduledArrivalTime") + " ");
        		System.out.print(rs.getString("DriverName") + " ");
        		System.out.print(rs.getString("BusID") + "\n");
        
        }

        //return query results
        return resultSet;

    }

    //query 2.c
    public int changeDriver(String driverName, String tripNumber, String date, String scheduledStartTime ) throws SQLException {

        //build query string
        String sql = "UPDATE TripOffering\n" +
                "SET DriverName = ?\n" +
                "WHERE TripNumber = ? AND Date = ? AND ScheduledStartTime = ?;";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, driverName);
        completeQuery.setString(2, tripNumber);
        completeQuery.setString(3, date);
        completeQuery.setString(4, scheduledStartTime);

        //execute query
        int resultSet = completeQuery.executeUpdate();

        if(resultSet > 0) {
	        sql = "SELECT * FROM TripOffering";
	        completeQuery = connection.prepareStatement(sql);
	        ResultSet rs = completeQuery.executeQuery();
	        
	        System.out.println("Current Trip Offerings after driver update: ");
	        while(rs.next()) {
	        		System.out.print(rs.getString("TripNumber") + " ");
	        		System.out.print(rs.getString("Date") + " ");
	        		System.out.print(rs.getString("ScheduledStartTime") + " ");
	        		System.out.print(rs.getString("ScheduledArrivalTime") + " ");
	        		System.out.print(rs.getString("DriverName") + " ");
	        		System.out.print(rs.getString("BusID") + "\n");
	        }
    		}
        
        //return query results
        return resultSet;

    }

    //query 2.d
    public int changeBus(String busID, String tripNumber, String date, String scheduledStartTime) throws SQLException {
        //build query string
        String sql = "UPDATE TripOffering\n" +
                "SET BusID = ?\n" +
                "WHERE TripNumber = ? AND Date = ? AND ScheduledStartTime = ?;";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, busID);
        completeQuery.setString(2, tripNumber);
        completeQuery.setString(3, date);
        completeQuery.setString(4, scheduledStartTime);

        int resultSet = completeQuery.executeUpdate();
        
        if(resultSet > 0) {
	        sql = "SELECT * FROM TripOffering";
	        completeQuery = connection.prepareStatement(sql);
	        ResultSet rs = completeQuery.executeQuery();
	        
	        System.out.println("Current Trip Offerings after bus update: ");
	        while(rs.next()) {
	        		System.out.print(rs.getString("TripNumber") + " ");
	        		System.out.print(rs.getString("Date") + " ");
	        		System.out.print(rs.getString("ScheduledStartTime") + " ");
	        		System.out.print(rs.getString("ScheduledArrivalTime") + " ");
	        		System.out.print(rs.getString("DriverName") + " ");
	        		System.out.print(rs.getString("BusID") + "\n");
	        }
    		}
        
        return resultSet;
    }

    //query 3
    public ResultSet displayStops() throws SQLException {
        //build query string
        String sql = "SELECT TripNumber, StopNumber, SequenceNumber, DrivingTime\n" +
                "FROM TripStopInfo;";

        PreparedStatement completeQuery = connection.prepareStatement(sql);
        ResultSet resultSet = completeQuery.executeQuery();
        return resultSet;
    }

    //query 4
    public ResultSet displayWeeklySchedule(String driverName, String date) throws SQLException{
        String sql = "SELECT T2.TripNumber, T2.Date, T2.ScheduledStartTime, T2.ScheduledArrivalTime, T2.DriverName, T2.BusID\n" +
                "FROM Driver D, TripOffering T2\n" +
                "WHERE D.DriverName = T2.DriverName AND T2.DriverName = ? AND T2.Date = ?;";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, driverName);
        completeQuery.setString(2, date);

        ResultSet resultSet = completeQuery.executeQuery();
        return resultSet;

    }

    //query 5
    public int addDriver(String driverName, String driverTelephoneNumber) throws SQLException {
        String sql = "INSERT INTO Driver (DriverName, DriverTelephoneNumber)\n" +
                "VALUES\n" +
                "\t(?, ?);\n";
        
        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, driverName);
        completeQuery.setString(2, driverTelephoneNumber);

        int resultSet = completeQuery.executeUpdate();
        
        if(resultSet > 0) {
	        sql = "SELECT * FROM Driver";
	        completeQuery = connection.prepareStatement(sql);
	        ResultSet rs = completeQuery.executeQuery();
	        
	        System.out.println("Current Drivers after driver update: ");
	        while(rs.next()) {
	        		System.out.print(rs.getString("DriverName") + " ");
	        		System.out.print(rs.getString("DriverTelephoneNumber") + "\n");
	        }
    		}
        
        return resultSet;
    }

    //query 6
    public int addBus(String busID, String busModel, String year) throws SQLException {
        String sql = "INSERT INTO Bus (BusID, Model, Year)\n" +
                "VALUES\n" +
                "\t(?, ?, ?);";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, busID);
        completeQuery.setString(2, busModel);
        completeQuery.setString(3, year);

        int resultSet = completeQuery.executeUpdate();
        
        if(resultSet > 0) {
	        sql = "SELECT * FROM Bus";
	        completeQuery = connection.prepareStatement(sql);
	        ResultSet rs = completeQuery.executeQuery();
	        
	        System.out.println("Current bus info after bus insert: ");
	        while(rs.next()) {
	        		System.out.print(rs.getString("BusID") + " ");
	        		System.out.print(rs.getString("Model") + " ");
	        		System.out.print(rs.getString("Year") + "\n");
	        }
    		}
        
        return resultSet;
    }

    //query 7
    public int deleteBus(String busID) throws SQLException {
        String sql = "DELETE FROM Bus\n" +
                "WHERE BusID = ?;";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, busID);

        int resultSet = completeQuery.executeUpdate();
        
        if(resultSet > 0) {
	        sql = "SELECT * FROM Bus";
	        completeQuery = connection.prepareStatement(sql);
	        ResultSet rs = completeQuery.executeQuery();
	        
	        System.out.println("Current Bus info after bus update: ");
	        while(rs.next()) {
	        		System.out.print(rs.getString("BusID") + " ");
	        		System.out.print(rs.getString("Model") + " ");
	        		System.out.print(rs.getString("Year") + "\n");
	        }
    		}
        
        return resultSet;
    }

    //query 8
    public int addActualTrip(String tripNumber,String date,String scheduledStartTime,String stopNumber,String scheduledArrivalTime,String actualStartTime,String actualArrivalTime,String numberOfPassengerIn,String numberOfPassengerOut) throws SQLException {
        String sql = "INSERT INTO ActualTripStopInfo (TripNumber, Date, ScheduledStartTime, StopNumber, ScheduledArrivalTime, ActualStartTime, ActualArrivalTime, NumberOfPassengerIn, NumberOfPassengerOut)\n" +
                "VALUES\n" +
                "\t(?, ?, ?, ?, ?, ?, ?, ?, ?);\n";

        //add user input to string
        PreparedStatement completeQuery = connection.prepareStatement(sql);
        completeQuery.setString(1, tripNumber);
        completeQuery.setString(2, date);
        completeQuery.setString(3, scheduledStartTime);
        completeQuery.setString(4, stopNumber);
        completeQuery.setString(5, scheduledArrivalTime);
        completeQuery.setString(6, actualStartTime);
        completeQuery.setString(7, actualArrivalTime);
        completeQuery.setString(8, numberOfPassengerIn);
        completeQuery.setString(9, numberOfPassengerOut);

        int resultSet = completeQuery.executeUpdate();
        
        if(resultSet > 0) {
	        sql = "SELECT * FROM ActualTripStopInfo";
	        completeQuery = connection.prepareStatement(sql);
	        ResultSet rs = completeQuery.executeQuery();
	        
	        System.out.println("Current Actual Trip Stop Info after update: ");
	        while(rs.next()) {
	        		System.out.print(rs.getString("TripNumber") + " ");
	        		System.out.print(rs.getString("Date") + " ");
	        		System.out.print(rs.getString("ScheduledStartTime") + " ");
	        		System.out.print(rs.getString("StopNumber") + " ");
	        		System.out.print(rs.getString("ScheduledArrivalTime") + " ");
	        		System.out.print(rs.getString("ActualStartTime") + " ");
	        		System.out.print(rs.getString("ActualArrivalTime") + " ");
	        		System.out.print(rs.getString("NumberOfPassengerIn") + " ");
	        		System.out.print(rs.getString("NumberOfPassengerOut") + "\n");
	        }
    		}
        
        return resultSet;
    }
}

