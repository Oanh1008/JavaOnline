package bean;

public interface FileTransfer  {
	/**
	 * convert from object to string before writing to file
	 * @param t object type
	 * @return string
	 */
	String toLine();

}
