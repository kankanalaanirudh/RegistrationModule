package com.techjava.registration.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
 * This ResourceNotException for custom Exception
 * @author VishnuVardhan
 * 
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
//This method for giving custom Exceptions
	public ResourceNotFoundException(String message){
    	super(message);
    }
}
