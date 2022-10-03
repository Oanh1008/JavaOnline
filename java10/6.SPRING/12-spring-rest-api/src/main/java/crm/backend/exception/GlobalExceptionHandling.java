package crm.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleNotFoundException(ElementNotFoundException enfe) {
		int status = HttpStatus.NOT_FOUND.value();
		String message = enfe.getMessage();
		String dt = CustomErrorResponse.now("yyyy/MM/dd 'T' HH:mm:ss");
		CustomErrorResponse ser = new CustomErrorResponse(status, message, dt);
		return new ResponseEntity<>(ser, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception ex) {
		int status = HttpStatus.BAD_REQUEST.value();
		String message = ex.getMessage();
		String dt = CustomErrorResponse.now("yyyy/MM/dd 'T' HH:mm:ss");
		CustomErrorResponse ser = new CustomErrorResponse(status, message, dt);
		return new ResponseEntity<>(ser, HttpStatus.BAD_REQUEST);
		
	}
}
