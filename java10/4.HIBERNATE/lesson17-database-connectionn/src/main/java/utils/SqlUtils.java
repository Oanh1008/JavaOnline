package utils;

public class SqlUtils {
	private SqlUtils() {
		
	}
	public static void close(AutoCloseable ...autoCloseables) {
		for(AutoCloseable closeable:autoCloseables) {
			try {
				if(closeable!=null) {
					closeable.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
