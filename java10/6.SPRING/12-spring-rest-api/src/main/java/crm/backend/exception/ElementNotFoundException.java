package crm.backend.exception;

public class ElementNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = -1487515283679421917L;

	public ElementNotFoundException(String message) {
		super(message);
	}
}
