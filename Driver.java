import java.sql.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			//1. Get connection to database
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4", "root", "root");
			
			//Create and Execute SQL Query
			Statement state = connect.createStatement();
			
			//2. Create Tables
			//Scanner createTable = new Scanner(new FileReader("Lab4.sql"));
			//while loop
				//REGEX to find ;
			
			//3. Insert Data
			//Scanner insertData = new Scanner(new FileReader("Lab4Data.sql"));
			//String insert = ;
			
			//CS 435 MENU
			System.out.println("--- CS435 DATABASES MENU ---");
			
			//Query
			Scanner kb = new Scanner(System.in);
			
			System.out.println("1. Display the schedule of all trips for a given StartLocationName and Destination Name, and Date.");
			System.out.println("Enter Start Location Name: ");
			String startLocationName = kb.nextLine();
			startLocationName = startLocationName.trim();
			
			System.out.println("Enter Destination Name: ");
			String destinationName = kb.nextLine();
			destinationName = destinationName.trim();
			
			System.out.println("Enter Date: ");
			String date = kb.nextLine();
			date = date.trim();
			
//			String sql = "SELECT TO.ScheduledStartTime, TO.ScheduledArrivalTime, TO.DriverName, TO.BusID " + 
//						 "FROM TripOffering TO, Trip T " + 
//						 "WHERE T.StartLocationName = '" + startLocationName + "' AND T.DestinationName = '" + destinationName + "' AND T.Date = '" + date + "'";
//			ResultSet rs = state.executeQuery(sql);
			
			//Process Result Set
//			while(rs.next()) {
//				System.out.println(rs.getString("DriverName"));
//			}
			
			String sql = "SELECT T2.ScheduledStartTime, T2.ScheduledArrivalTime, T2.DriverName, T2.BusID " + 
					 	"FROM TripOffering T2, Trip T " + 
					 	"WHERE T.TripNumber = T2.TripNumber AND  T.StartLocationName = ? AND T.DestinationName = ? AND T2.Date = ?";
			PreparedStatement myStmt = connect.prepareStatement(sql);
			myStmt.setString(1, startLocationName);
			myStmt.setString(2, destinationName);
			myStmt.setString(3, date);
			
			ResultSet myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				System.out.println(myRs.getString("ScheduledStartTime"));
				System.out.println(myRs.getString("ScheduledArrivalTime"));
				System.out.println(myRs.getString("DriverName"));
				System.out.println(myRs.getString("BusID"));
			}
			
			
			//Clean up
			//createTable.close();
			//insertData.close();
			//rs.close();
			state.close();
			connect.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
