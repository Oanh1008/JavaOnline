package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	
	private static Connection conn=null;

	public static Connection getConnection() {
		
		
		if(conn==null) {
			// driver
			
			try {
				Properties props= DbProvider.getprops();
				//Driver.class.getName();
				Class.forName(props.getProperty("Driver"));
				conn=DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
			} catch (ClassNotFoundException |SQLException |IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
		System.out.println("Da ket noi");
	}
}
