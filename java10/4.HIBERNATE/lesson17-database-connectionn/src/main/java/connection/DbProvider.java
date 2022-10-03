package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProvider {
	private static final String DB_CONFIG = "database.properties";

	private DbProvider() {

	}

	public static Properties getConfig() {
		Properties props = new Properties();

		try {
			InputStream stream = new FileInputStream(new File(DB_CONFIG));
			props.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;

	}
}
