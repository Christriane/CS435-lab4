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

    public TerminalMenu(Connection connection) {
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
            choice = scanner.nextLine();
            runChoice();
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
        System.out.println("Enter Start Location Name: ");
        String startLocationName = scanner.nextLine();

        System.out.println("Enter Destination Name: ");
        String destinationName = scanner.nextLine();

        System.out.println("Enter Date: ");
        String date = scanner.nextLine();
		
		System.out.println("*** Query 1 Results ***");
        displayResults.display(sqlQueries.displaySchedule(startLocationName, destinationName, date));
        System.out.println();
        //Pomona, Walnut, 1-1-2001
    }

    private void queryTwo() throws SQLException {
        // query 2.a
        System.out.println("Enter Trip Number: ");
		String tripNum = scanner.nextLine();

		System.out.println("Enter Date: ");
		String date = scanner.nextLine();

		System.out.println("Enter Start Time: ");
		String startTime = scanner.nextLine();

        System.out.println("*** Query 2a Results ***");
        displayResults.displayTwo(sqlQueries.deleteTrip(tripNum, date, startTime));
        System.out.println();
        //Trip1, 1-1-2001, MON 10:00AM
    }
    
    private void queryThree() throws SQLException {
        //query 2.b
    		System.out.println("Enter Trip Number: ");
		String tripNum = scanner.nextLine();

		System.out.println("Enter Date: ");
		String date = scanner.nextLine();

		System.out.println("Enter Scheduled Start Time: ");
		String startTime = scanner.nextLine();
		
		System.out.println("Enter Scheduled Arrival Time: ");
		String arrivalTime = scanner.nextLine();
		
		System.out.println("Enter Driver Name: ");
		String driverName = scanner.nextLine();
		
		System.out.println("Enter BusID: ");
		String busID = scanner.nextLine();
    	
		System.out.println("*** Query 2b Results ***");
        displayResults.displayThree(sqlQueries.addTrip(tripNum, date, startTime, arrivalTime, driverName, busID));
        System.out.println();
        //Trip1, 11-21-2017, MON 10:55AM, MON 12:00PM, Driver1, Bus2
    }
    
    private void queryFour() throws SQLException {
        //query 2.c
    		System.out.println("Enter Driver Name: ");
		String driverName = scanner.nextLine();

		System.out.println("Enter Trip Number: ");
		String tripNum = scanner.nextLine();

		System.out.println("Enter Date: ");
		String date = scanner.nextLine();
		
		System.out.println("Enter Scheduled Start Time: ");
		String startTime = scanner.nextLine();
    	
    		System.out.println("*** Query 2c Results ***");
        displayResults.displayFour(sqlQueries.changeDriver(driverName, tripNum, date, startTime));
        System.out.println();
        //Driver1, Trip10, 1-10-2001, SUN 10:00AM
    }
    
    private void queryFive() throws SQLException {
        //query 2.d
    		System.out.println("Enter Bus ID: ");
		String driverName = scanner.nextLine();

		System.out.println("Enter Trip Number: ");
		String tripNum = scanner.nextLine();

		System.out.println("Enter Date: ");
		String date = scanner.nextLine();
		
		System.out.println("Enter Scheduled Start Time: ");
		String startTime = scanner.nextLine();
    	
    		System.out.println("*** Query 2d Results ***");
        displayResults.displayFour(sqlQueries.changeBus(driverName, tripNum, date, startTime));
        System.out.println();
        //Bus10, Trip9, 1-9-2001, SUN 10:00AM
    }
    
    private void querySix() throws SQLException {
        //query 3
    		System.out.println("*** Query 3 Results ***");
        displayResults.displayFive(sqlQueries.displayStops());
        System.out.println();
    }
    
    private void querySeven() throws SQLException {
        //query 4
    		System.out.println("Enter Driver Name: ");
		String driverName = scanner.nextLine();
		
		System.out.println("Enter Date: ");
		String date = scanner.nextLine();
    	
    		System.out.println("*** Query 4 Results ***");
        displayResults.displaySix(sqlQueries.displayWeeklySchedule(driverName, date));
        System.out.println();
        //Driver7, 1-7-2001
    }
    
    private void queryEight() throws SQLException {
        //query 5
    		System.out.println("Enter Driver Name: ");
		String driverName = scanner.nextLine();
		
		System.out.println("Enter Telephone Number: ");
		String telephoneNum = scanner.nextLine();
    	
        System.out.println("*** Query 5 Results ***");
        displayResults.displayThree(sqlQueries.addDriver(driverName, telephoneNum));
        System.out.println();
        //<name>, <telephone>
    }
    
    private void queryNine() throws SQLException {
        //query 6
    		System.out.println("Enter Bus Number: ");
		String busID = scanner.nextLine();
		
		System.out.println("Enter Bus Model: ");
		String model = scanner.nextLine();
		
		System.out.println("Enter Bus Year: ");
		String year = scanner.nextLine();
    	
        System.out.println("*** Query 6 Results ***");
        displayResults.displayThree((sqlQueries.addBus(busID, model, year)));
        System.out.println();
        //<busID>, <model>, <year>
    }
    
    private void queryTen() throws SQLException {
        //query 7
    		System.out.println("Enter Bus Number: ");
		String busID = scanner.nextLine();
    	
        System.out.println("*** Query 7 Results ***");
        displayResults.displayTwo(sqlQueries.deleteBus(busID));
        System.out.println();
        //<busID>
    }
    
    private void queryEleven() throws SQLException {
        //query 8
    		System.out.println("Enter Trip Number: ");
		String tripNum = scanner.nextLine();
		
		System.out.println("Enter Date: ");
		String date = scanner.nextLine();
		
		System.out.println("Enter Scheduled Start Time: ");
		String startTime = scanner.nextLine();
		
		System.out.println("Enter Stop Number: ");
		String stopNum = scanner.nextLine();
		
		System.out.println("Enter Scheduled Arrival Time: ");
		String arrivalTime = scanner.nextLine();
		
		System.out.println("Enter Actual Start Time: ");
		String actualStartTime = scanner.nextLine();
		
		System.out.println("Enter Actual Arrival Time: ");
		String actualArrivalTime = scanner.nextLine();
		
		System.out.println("Enter Number Of Passengers In: ");
		String passengersIn = scanner.nextLine();
		
		System.out.println("Enter Number Of Passengers Out: ");
		String passengersOut = scanner.nextLine();
    	
    		System.out.println("*** Query 8 Results ***");
        displayResults.displayThree(sqlQueries.addActualTrip(tripNum, date, startTime, stopNum, arrivalTime, actualStartTime, actualArrivalTime, passengersIn, passengersOut));
        System.out.println();
        //Trip2, 1-2-2001, TUE 10:00AM, Stop1, TUE 2:45PM, 1, 1, 1, 1
    }
}
