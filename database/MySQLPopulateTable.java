package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLPopulateTable implements PopulateTable {

    private Statement statement;
    private Connection connection;

    public MySQLPopulateTable(Connection connection){
        this.connection = connection;
    }

    @Override
    public void populateTables() throws SQLException {


        String bus = "INSERT INTO Bus (BusID, Model, Year)\n" +
                "VALUES\n" +
                "\t(\"Bus1\", \"Blue Bird\", \"2000\"),\n" +
                "    (\"Bus2\", \"Blue Bird\", \"2000\"),\n" +
                "    (\"Bus3\", \"Chance Coach\", \"2001\"),\n" +
                "    (\"Bus4\", \"Chance Coach\", \"2001\"),\n" +
                "    (\"Bus5\", \"General Coach\", \"2002\"),\n" +
                "    (\"Bus6\", \"General Coach\", \"2002\"),\n" +
                "    (\"Bus7\", \"Astra Bus\", \"2003\"),\n" +
                "    (\"Bus8\", \"Astra Bus\", \"2003\"),\n" +
                "    (\"Bus9\", \"Express Coach\", \"2004\"),\n" +
                "    (\"Bus10\", \"Express Coach\", \"2004\");";

        String driver = "INSERT INTO Driver (DriverName, DriverTelephoneNumber)\n" +
                "VALUES\n" +
                "\t(\"Driver1\", \"(909) 123-4561\"),\n" +
                "    (\"Driver2\", \"(909) 123-4562\"),\n" +
                "    (\"Driver3\", \"(909) 123-4563\"),\n" +
                "    (\"Driver4\", \"(909) 123-4564\"),\n" +
                "    (\"Driver5\", \"(909) 123-4565\"),\n" +
                "    (\"Driver6\", \"(909) 123-4566\"),\n" +
                "    (\"Driver7\", \"(909) 123-4567\"),\n" +
                "    (\"Driver8\", \"(909) 123-4568\"),\n" +
                "    (\"Driver9\", \"(909) 123-4569\"),\n" +
                "    (\"Driver10\", \"(909) 123-4560\");";

        String tripOffering = "INSERT INTO TripOffering (TripNumber, Date, ScheduledStartTime, ScheduledArrivalTime, DriverName, BusID)\n" +
                "VALUES\n" +
                "\t(\"Trip1\", \"1-1-2001\", \"MON 10:00AM\", \"MON 1:00PM\", \"Driver1\", \"Bus1\"),\n" +
                "    (\"Trip2\", \"1-2-2001\", \"TUE 10:00AM\", \"TUE 2:45PM\", \"Driver2\", \"Bus2\"),\n" +
                "    (\"Trip3\", \"1-3-2001\", \"WED 10:00AM\", \"WED 5:00PM\", \"Driver3\", \"Bus3\"),\n" +
                "    (\"Trip4\", \"1-4-2001\", \"TH 10:00AM\", \"TH 7:30PM\", \"Driver4\", \"Bus4\"),\n" +
                "    (\"Trip5\", \"1-5-2001\", \"FRI 10:00AM\", \"FRI 12:00PM\", \"Driver5\", \"Bus5\"),\n" +
                "    (\"Trip6\", \"1-6-2001\", \"FRI 10:00AM\", \"FRI 9:00PM\", \"Driver6\", \"Bus6\"),\n" +
                "    (\"Trip7\", \"1-7-2001\", \"SAT 10:00AM\", \"SAT 6:30PM\", \"Driver7\", \"Bus7\"),\n" +
                "    (\"Trip8\", \"1-8-2001\", \"SAT 10:00AM\", \"SAT 4:00PM\", \"Driver8\", \"Bus8\"),\n" +
                "    (\"Trip9\", \"1-9-2001\", \"SUN 10:00AM\", \"SUN 11:00PM\", \"Driver9\", \"Bus9\"),\n" +
                "    (\"Trip10\", \"1-10-2001\", \"SUN 10:00AM\", \"SUN 10:30PM\", \"Driver10\", \"Bus10\");\n" +
                "    ";

        String trip = "INSERT INTO Trip (TripNumber, StartLocationName, DestinationName)\n" +
                "VALUES\n" +
                "\t(\"Trip1\", \"Pomona\", \"Walnut\"),\n" +
                "    (\"Trip2\", \"Pomona\", \"Brea\"),\n" +
                "    (\"Trip3\", \"Pomona\", \"Ontario\"),\n" +
                "    (\"Trip4\", \"Pomona\", \"Los Angeles\"),\n" +
                "    (\"Trip5\", \"Pomona\", \"West Covina\"),\n" +
                "    (\"Trip6\", \"Pomona\", \"Lancaster\"),\n" +
                "    (\"Trip7\", \"Pomona\", \"Pasadena\"),\n" +
                "    (\"Trip8\", \"Pomona\", \"Irvine\"),\n" +
                "    (\"Trip9\", \"Pomona\", \"Santa Barbara\"),\n" +
                "    (\"Trip10\", \"Pomona\", \"San Diego\");";

        String stop = "INSERT INTO Stop (StopNumber, StopAddress)\n" +
                "VALUES\n" +
                "\t(\"Stop1\", \"100 Grand Ave\"),\n" +
                "    (\"Stop2\", \"200  Lambert St\"),\n" +
                "    (\"Stop3\", \"300 Foothill Ave\"),\n" +
                "    (\"Stop4\", \"400 Cesar Chavez\"),\n" +
                "    (\"Stop5\", \"500 Cameron Ave\"),\n" +
                "    (\"Stop6\", \"600 Grove Dr\"),\n" +
                "    (\"Stop7\", \"700 Colorado Ave\"),\n" +
                "    (\"Stop8\", \"800 Tustin St\"),\n" +
                "    (\"Stop9\", \"900 Beach Lane\"),\n" +
                "    (\"Stop10\", \"110 La Jolla St\");\n" +
                "    ";

        String actualTripStopInfo = "INSERT INTO ActualTripStopInfo (TripNumber, Date, ScheduledStartTime, StopNumber, ScheduledArrivalTime, ActualStartTime, ActualArrivalTime, NumberOfPassengerIn, NumberOfPassengerOut)\n" +
                "VALUES\t\n" +
                "    (\"Trip1\", \"1-1-2001\", \"MON 10:00AM\", \"Stop1\", \"MON 1:00PM\", \"MON 10:30AM\", \"MON 2:00PM\", \"10\", \"10\"),\n" +
                "    (\"Trip2\", \"1-2-2001\", \"TUE 10:00AM\", \"Stop2\", \"TUE 2:45PM\", \"TUE 10:00AM\", \"TUE 2:30PM\", \"15\", \"7\"),\n" +
                "    (\"Trip3\", \"1-3-2001\", \"WED 10:00AM\", \"Stop3\", \"WED 5:00PM\", \"WED 10:45AM\", \"WED 6:00PM\", \"20\", \"18\"),\n" +
                "    (\"Trip4\", \"1-4-2001\", \"TH 10:00AM\", \"Stop4\", \"TH 7:30PM\", \"TH 10:10AM\", \"TH 7:45PM\", \"13\", \"10\"),\n" +
                "    (\"Trip5\", \"1-5-2001\", \"FRI 10:00AM\", \"Stop5\", \"FRI 12:00PM\", \"FRI 11:30AM\", \"FRI 2:00PM\", \"9\", \"9\"),\n" +
                "    (\"Trip6\", \"1-6-2001\", \"FRI 10:00AM\", \"Stop6\", \"FRI 9:00PM\", \"FRI 10:00AM\", \"FRI 9:00PM\", \"22\", \"16\"),\n" +
                "    (\"Trip7\", \"1-7-2001\", \"SAT 10:00AM\", \"Stop7\", \"SAT 6:30PM\", \"SAT 10:20AM\", \"SAT 7:00PM\", \"7\", \"4\"),\n" +
                "    (\"Trip8\", \"1-8-2001\", \"SAT 10:00AM\", \"Stop8\", \"SAT 4:00PM\", \"SAT 10:50AM\", \"SAT 5:00PM\", \"19\", \"14\"),\n" +
                "    (\"Trip9\", \"1-9-2001\", \"SUN 10:00AM\", \"Stop9\", \"SUN 11:00PM\", \"SUN 10:55AM\", \"SUN 12:30AM\", \"30\", \"21\"),\n" +
                "    (\"Trip10\", \"1-10-2001\", \"SUN 10:00AM\", \"Stop10\", \"SUN 10:30PM\", \"SUN 10:15AM\", \"SUN 10:55PM\", \"25\", \"18\");\n" +
                "    ";

        String tripStopInfo = "INSERT INTO TripStopInfo(TripNumber, StopNumber, SequenceNumber, DrivingTime)\n" +
                "VALUES\n" +
                "\t(\"Trip1\", \"Stop1\", \"Sequence1\", \"200 Minutes\"),\n" +
                "    (\"Trip2\", \"Stop2\", \"Sequence2\", \"300 Minutes\"),\n" +
                "    (\"Trip3\", \"Stop3\", \"Sequence3\", \"400 Minutes\"),\n" +
                "    (\"Trip4\", \"Stop4\", \"Sequence4\", \"500 Minutes\"),\n" +
                "    (\"Trip5\", \"Stop5\", \"Sequence5\", \"250 Minutes\"),\n" +
                "    (\"Trip6\", \"Stop6\", \"Sequence6\", \"350 Minutes\"),\n" +
                "    (\"Trip7\", \"Stop7\", \"Sequence7\", \"450 Minutes\"),\n" +
                "    (\"Trip8\", \"Stop8\", \"Sequence8\", \"550 Minutes\"),\n" +
                "    (\"Trip9\", \"Stop9\", \"Sequence9\", \"260 Minutes\"),\n" +
                "    (\"Trip10\", \"Stop10\", \"Sequence10\", \"360 Minutes\");\n" +
                "    ";

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
