package utils;

public class SqlUtils {
	private SqlUtils() {
		
	}
	public static void close(AutoCloseable ...autoCloseables) {
		for(AutoCloseable closable:autoCloseables) {
			try {
				if(closable !=null)
					closable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
	
