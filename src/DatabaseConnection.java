import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DatabaseConnection {
	private DatabaseConnection(){}
	
	public static Connection getDbConnection() {
		Connection dbConnection = null;
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		try {
			dbConnection = DriverManager.getConnection(bundle.getString("url"), bundle.getString("username"),bundle.getString("password"));
			
			if (dbConnection != null) {
				System.out.println("Connection successful");
			} else {
				System.out.println("Unable to connect to DB");
			}
			
		} catch (Exception e) {
			System.out.println("Exception occurred in DatabaseConnection -> getDbConnection()");
			System.out.println("Error: " + e);
			e.printStackTrace();
		} 
		return dbConnection;
	} 
}
