package com.cg.hcs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
	ResponseEntity<String> responseEntity;
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;		
	}

	
	@ExceptionHandler(DiagnosticCenterException.class)
	public ResponseEntity<String> handleDiagnosticCenterException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;		
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;	
		
	}
	
	@ExceptionHandler(DiagnosticTestException.class)
	public ResponseEntity<String> handleDiagnosticTestException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;	
	}
	@ExceptionHandler(AppointmentException.class)
	public ResponseEntity<String> handleAppointmenttException(Exception e){
		responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;	
	}
}
