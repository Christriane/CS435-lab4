package ui;

import database.SqlQueries;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TerminalMenu {

    private Scanner scanner;
    private DisplayResults displayResults;
    private Connection connection;
    private SqlQueries sqlQueries;

    private String choice;

    public TerminalMenu(Connection connection){
        this.connection = connection;
        scanner = new Scanner(System.in);
        displayResults = new DisplayResults();
        sqlQueries = new SqlQueries(this.connection);


    }

    public void menu() throws SQLException {

        while(true){
            System.out.println("Lab4 - Menu");
            System.out.println("----------------------");
            System.out.println("1. Display the schedule of all trips for a given StartLocationName and Destination Name, and Date");
            System.out.println("2. Delete a trip offering specified by Trip#, Date, and ScheduledStartTime");
            System.out.println("3. Add a set of trip offerings assuming the values of all attributes are given (the software asks if you have more trips to enter)");
            System.out.println("4. Change the driver for a given Trip offering (i.e given TripNumber, Date, ScheduledStartTime)");
            System.out.println("5. Change the bus for a given Trip offering");
            System.out.println("6. Display the stops of a given trip ( i.e. the attributes of the table TripStopInfo)");
            System.out.println("7. Display the weekly schedule of a given driver and date");
            System.out.println("8. Add a driver");
            System.out.println("9. Add a bus");
            System.out.println("10. Delete a bus");
            System.out.println("11. Record (insert) the actual data of a given trip offering specified by its key. The actual data include the attributes of the table ActualTripStopInfo");
            System.out.println("12. Exit");
            System.out.println("----------------------");

            System.out.println("Choice?");
            choice = scanner.next();
            runChoice();
            System.out.println("");
        }
    }

    //probably should create methods for each query since we need user input
    private void runChoice() throws SQLException {
        switch (this.choice) {
            case "1":
                queryOne();
                break;
            case "2":
                queryTwo();
                 break;
            case "3":
                queryThree();
                break;
            case "4":
                queryFour();
                break;
            case "5":
                queryFive();
                 break;
            case "6":
                querySix();
                break;
            case "7":
                querySeven();
                break;
            case "8":
                queryEight();
                break;
            case "9":
                queryNine();
                break;
            case "10":
                queryTen();
                break;
            case "11":
                queryEleven();
                break;
            case "12":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }
    }

    /*
        TODO: Replace hard coded values in the methods below with user input. a Scanner is already defined too, named: scanner
     */

    private void queryOne() throws SQLException {
        // query 1
        System.out.println("Query 1 Results");
        displayResults.display(sqlQueries.displaySchedule("Pomona", "Walnut", "1-1-2001"));

    }

    private void queryTwo() throws SQLException {
        // query 2.a
        System.out.println("Query 2 Results");
        displayResults.displayTwo(sqlQueries.deleteTrip("Trip1","1-1-2001","MON 10:00AM"));


    }
    private void queryThree() throws SQLException {
        //query 2.b
        displayResults.displayThree(sqlQueries.addTrip("Trip1","11-21-2017","MON 10:55AM","MON 12:00PM","Driver1","Bus2"));

    }
    private void queryFour() throws SQLException {
        //query 2.c
        displayResults.displayFour(sqlQueries.changeDriver("Driver1","Trip10","1-10-2001","SUN 10:00AM"));

    }
    private void queryFive() throws SQLException {
        //query 2.d
        displayResults.displayFour(sqlQueries.changeBus("Bus10","Trip9","11-9-2001","SUN 10:00AM"));

    }
    private void querySix() throws SQLException {
        //query 3
        displayResults.displayFive(sqlQueries.displayStops());

    }
    private void querySeven() throws SQLException {
        //query 4
        displayResults.displaySix(sqlQueries.displayWeeklySchedule("Driver7","1-7-2001"));

    }
    private void queryEight() throws SQLException {
        //query 5
        System.out.println("Query 5 Results");
        displayResults.displayThree(sqlQueries.addDriver("jamz","909-999-8888"));

    }
    private void queryNine() throws SQLException {
        //query 6
        System.out.println("Query 6 Results");
        displayResults.displayThree((sqlQueries.addBus("Bus9999","Tesla","2020")));

    }
    private void queryTen() throws SQLException {
        //query 7
        System.out.println("Query 7 Results");
        displayResults.displayTwo(sqlQueries.deleteBus("Bus999"));

    }
    private void queryEleven() throws SQLException {
        //query 8
        // Can't change due to foreign key constraint
        displayResults.displayThree(sqlQueries.addActualTrip("Trip2","1-2-2001","TUE 10:00AM","Stop1","TUE 2:45PM","1","1", "1", "1"));

    }


}
