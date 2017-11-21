package ui;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayResults {

    public DisplayResults(){
    }

    public void display(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                System.out.print(resultSet.getString("ScheduledStartTime"));
                System.out.print(resultSet.getString("ScheduledArrivalTime"));
                System.out.print(resultSet.getString("DriverName"));
                System.out.print(resultSet.getString("BusID"));
                System.out.println();
            }
        }

    public void displayTwo(int resultSet) throws SQLException {
        //what to display?
        System.out.println(resultSet+"Deleted!");
    }
}
