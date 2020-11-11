package com.codelabs.exceptionHandler;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codelabs.exception.BookIdMismatchException;
import com.codelabs.exception.BookNotFoundException;
import com.codelabs.exception.EntityNotFoundException;
import com.codelabs.exception.ValidationException;
import com.codelabs.response.BaseResponse;
import com.codelabs.utility.ErrorConstants;
import com.codelabs.utility.ErrorUtil;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private ErrorUtil errorUtil;
 
    @ExceptionHandler({ BookNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Book not found", 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
 
    @ExceptionHandler({ BookIdMismatchException.class, ConstraintViolationException.class, DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getLocalizedMessage(), 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException e){
    	BaseResponse response = new BaseResponse();
    	response.setErrors(errorUtil.getErrorList(e.getErrorCodes()));
    	return new ResponseEntity<>(response, httpHeaders, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<Object> handleMappingException(Exception e){
    	BaseResponse response = new BaseResponse();
    	response.setErrors(errorUtil.getErrorList(ErrorConstants.INVALID_JSON));
    	return new ResponseEntity<>(response, httpHeaders, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e){
    	BaseResponse response = new BaseResponse();
    	response.setErrors(errorUtil.getErrorList(e.getErrorCode()));
    	return new ResponseEntity<>(response, httpHeaders, HttpStatus.NOT_FOUND);
    }
}