package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	private static Connection connection;
	private static String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/shoppingdata";
	private static String USER = "root";
	private static String PASS = "10082001";

	public static Connection getConnection() {
		if (connection == null) {
			// driver
			try {
				Class.forName(DRIVER);

				connection = DriverManager.getConnection(URL, USER, PASS);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
