import java.sql.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			//1. Get connection to database
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4", "root", "root");
			
			//2. Create Tables
			//Scanner createTable = new Scanner(new FileReader("Lab4.sql"));
			//String create = ;
			
			//3. Insert Data
			//Scanner insertData = new Scanner(new FileReader("Lab4Data.sql"));
			//String insert = ;
			
			//MENU
			
			// Create and Execute SQL Query
			Statement state = connect.createStatement();
			String sql = "SELECT * FROM Driver";
			ResultSet rs = state.executeQuery(sql);
			
			// Process Result Set
			while(rs.next()) {
				System.out.println(rs.getString("DriverName"));
			}
			
			// Clean up
			sc.close();
			rs.close();
			state.close();
			connect.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
