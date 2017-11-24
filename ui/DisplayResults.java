package ui;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayResults {

    public DisplayResults(){
    }

    public void display(ResultSet resultSet) throws SQLException {

    		if (resultSet.next()) {
            System.out.print(resultSet.getString("ScheduledStartTime")+" ");
            System.out.print(resultSet.getString("ScheduledArrivalTime")+" ");
            System.out.print(resultSet.getString("DriverName")+" ");
            System.out.print(resultSet.getString("BusID")+"\n");
            
        } else{
            System.out.println("Empty Query Result");
        }
    }

    public void displayTwo(int resultSet) throws SQLException {
        if (resultSet > 0){
            System.out.println("Delete Successful");
        }else{
            System.out.println("Unable to delete");
        }
    }

    public void displayThree(int resultSet) throws SQLException{
        if (resultSet > 0){
            System.out.println("Insert Successful");
        }else{
            System.out.println("Unable to Insert");
        }
    }

    public void displayFour(int resultSet) throws SQLException{
        if (resultSet > 0){
            System.out.println("Update Successful");
        }else{
            System.out.println("Unable to Update");
        }
    }

    public void displayFive(ResultSet resultSet) throws SQLException{
        if (resultSet.next()) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("TripNumber")+" ");
                System.out.print(resultSet.getString("StopNumber")+" ");
                System.out.print(resultSet.getString("SequenceNumber")+" ");
                System.out.print(resultSet.getString("DrivingTime")+" ");
                System.out.println();
            }
        }else{
            System.out.println("Empty Query Result");
        }
    }

    public void displaySix(ResultSet resultSet) throws SQLException{
        if (resultSet.next()) {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("DriverName")+" ");
                System.out.print(resultSet.getString("Date")+" ");
                System.out.println();
            }
        }else{
            System.out.println("Empty Query Result");
        }

    }
}

