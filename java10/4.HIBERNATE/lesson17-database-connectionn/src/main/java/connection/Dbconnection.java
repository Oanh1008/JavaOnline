package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dbconnection {
	private static Connection connection;
	

	public static Connection getConnection() {
		
		if (connection == null) {
			// driver
			Properties props= DbProvider.getConfig();
			try {
				Class.forName(props.getProperty("DRIVER"));

				connection = DriverManager.getConnection(props.getProperty("URL"),props.getProperty("USER"), props.getProperty("PASSWORD"));

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
