package utils;

public class SqlUtils {
	private SqlUtils() {
		
	}
	public static void close(AutoCloseable ...autoCloseables) {
		for(AutoCloseable closeable:autoCloseables) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
