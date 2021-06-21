package Proj.Management.SaaS;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import Proj.Management.SaaS.Exception.EventNotFoundException;
import Proj.Management.SaaS.Exception.OrganizerNotFoundException;
import Proj.Management.SaaS.Exception.ParticipantNotFoundException;
import Proj.Management.SaaS.Exception.EmptyInputException;
import Proj.Management.SaaS.Exception.NoArgumentsFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EventNotFoundException.class)
	public ResponseEntity<String> handleEventNotFoundException(EventNotFoundException e){
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrganizerNotFoundException.class)
	public ResponseEntity<String> handleOrganizerNotFoundException(OrganizerNotFoundException e){
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ParticipantNotFoundException.class)
	public ResponseEntity<String> handleParticipantNotFoundException(ParticipantNotFoundException e){
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException e) {
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : Input field is empty",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoArgumentsFoundException.class)
	public ResponseEntity<String> hendleNoArgumentsFoundException(NoArgumentsFoundException e) {
		return new ResponseEntity<String>("WARNING: "+e.getMessage()+" : No Arguments",HttpStatus.FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpHeaders headers, HttpStatus s, WebRequest r){
		return new ResponseEntity<Object>("ERROR: "+e.getMessage()+" : Change the Http method type !!",HttpStatus.CONFLICT);
		
	}

}
