package ui;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayResults {

    public DisplayResults(){
    }

    public void display(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ScheduledStartTime"));
                System.out.println(resultSet.getString("ScheduledArrivalTime"));
                System.out.println(resultSet.getString("DriverName"));
                System.out.println(resultSet.getString("BusID"));
            }
        }
}
