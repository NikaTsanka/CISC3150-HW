import java.sql.*;
import java.util.Enumeration;

public class JDBCDriver {
	
	static Connection my_connection;

	public static void main(String[] args) {
		// This object will return available drivers
		Enumeration<Driver> ed = DriverManager.getDrivers();
		
		// Get the driver names
		System.out.println("Available JDBC Drivers");
		while(ed.hasMoreElements()) {
			System.out.println("JDBC Driver: " + ed.nextElement());
		}
		
		try {
			// Get a connection to database
			my_connection = DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/sakila","root", "1234");
			
			// Get metadata
			DatabaseMetaData dbMetaData = my_connection.getMetaData();
			
			// Get info about database
			System.out.println("\nProduct name/version: " + dbMetaData.getDatabaseProductName() + 
							   ": " + dbMetaData.getDatabaseProductVersion());
			
			// get info about current driver.
			System.out.println("\nJDBC Driver in use name/version: " + dbMetaData.getDriverName() + 
							   ": " + dbMetaData.getDriverVersion());
			
			// Create a statement
			Statement my_statement = my_connection.createStatement();
			
			// This will execute the query
			ResultSet my_results = my_statement.executeQuery
					("select * from sakila.actor");
						
			// Get the results.
			System.out.printf("\n%-12s %12s", "First Name", "Last Name");
			System.out.println("\n-------------------------");
			while (my_results.next()) {
				System.out.printf("\n%-12s %12s", 
						my_results.getString("first_name"),
						my_results.getString("last_name"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				my_connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
