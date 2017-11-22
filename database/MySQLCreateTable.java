package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCreateTable implements CreateTable {

    private Statement statement;
    private Connection connection;


    public MySQLCreateTable(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void createTables() throws SQLException {
        String bus = "CREATE TABLE Bus (\n" +
                "    BusID VARCHAR(18),\n" +
                "\tModel VARCHAR(18),\n" +
                "    Year VARCHAR(18),\n" +
                "    PRIMARY KEY (BusID)\n" +
                ");";


        String driver = "CREATE TABLE Driver (\n" +
                "    DriverName VARCHAR(18),\n" +
                "    DriverTelephoneNumber VARCHAR(18),\n" +
                "    PRIMARY KEY (DriverName)\n" +
                ");";

        String tripOffering = "CREATE TABLE TripOffering (\n" +
                "\tTripNumber VARCHAR(18),\n" +
                "    Date VARCHAR(18),\n" +
                "    ScheduledStartTime VARCHAR(18),\n" +
                "\tScheduledArrivalTime VARCHAR(18),\n" +
                "    DriverName VARCHAR(18),\n" +
                "    BusID VARCHAR(18),\n" +
                "\tPRIMARY KEY(Date, ScheduledStartTime, TripNumber),\n" +
                "    FOREIGN KEY(BusID) REFERENCES Bus(BusID)\n" +
                "\t\tON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "\tFOREIGN KEY(DriverName) REFERENCES Driver(DriverName)\n" +
                "\t\tON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");";

        String trip = "CREATE TABLE Trip (\n" +
                "\tTripNumber VARCHAR(18) PRIMARY KEY,\n" +
                "    StartLocationName VARCHAR(18),\n" +
                "    DestinationName VARCHAR(18)\n" +
                ");";

        String stop = "CREATE TABLE Stop (\n" +
                "\tStopNumber VARCHAR(18) PRIMARY KEY,\n" +
                "\tStopAddress VARCHAR(18)\n" +
                ");";

        String actualTripStopInfo = "CREATE TABLE ActualTripStopInfo (\n" +
                "\tTripNumber VARCHAR(18),\n" +
                "    Date VARCHAR(18),\n" +
                "    ScheduledStartTime VARCHAR(18),\n" +
                "    StopNumber VARCHAR(18),\n" +
                "    ScheduledArrivalTime VARCHAR(18),\n" +
                "    ActualStartTime VARCHAR(18),\n" +
                "    ActualArrivalTime VARCHAR(18),\n" +
                "    NumberofPassengerIn VARCHAR(18),\n" +
                "    NumberofPassengerOut VARCHAR(18),\n" +
                "    PRIMARY KEY(StopNumber, Date, ScheduledStartTime, TripNumber),\n" +
                "\tFOREIGN KEY(Date, ScheduledStartTime, TripNumber) REFERENCES TripOffering(Date, ScheduledStartTime, TripNumber)\n" +
                "\t\tON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "\tFOREIGN KEY(StopNumber) REFERENCES Stop(StopNumber)\n" +
                "\t\tON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");";

        String tripStopInfo = "CREATE TABLE TripStopInfo (\n" +
                "    TripNumber VARCHAR(18),\n" +
                "    StopNumber VARCHAR(18),\n" +
                "\tSequenceNumber VARCHAR(18),\n" +
                "    DrivingTime VARCHAR(18),\n" +
                "    PRIMARY KEY(StopNumber, TripNumber),\n" +
                "\tFOREIGN KEY(StopNumber) REFERENCES Stop(StopNumber)\n" +
                "\t\tON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "\tFOREIGN KEY(TripNumber) REFERENCES Trip(TripNumber)\n" +
                "\t\tON DELETE CASCADE ON UPDATE CASCADE\n" +
                ");";

        statement = connection.createStatement();
        statement.executeUpdate(bus);
        statement.executeUpdate(driver);
        statement.executeUpdate(tripOffering);
        statement.executeUpdate(trip);
        statement.executeUpdate(stop);
        statement.executeUpdate(actualTripStopInfo);
        statement.executeUpdate(tripStopInfo);


    }
}
