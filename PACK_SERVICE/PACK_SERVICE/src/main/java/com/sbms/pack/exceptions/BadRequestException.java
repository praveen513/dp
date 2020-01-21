package com.sbms.pack.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author DPraveen
 *
 */
public class BadRequestException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	  private final String message;
	  private final HttpStatus httpStatus;

	  public BadRequestException(String message, HttpStatus httpStatus) {
	    this.message = message;
	    this.httpStatus = httpStatus;
	  }

	  @Override
	  public String getMessage() {
	    return message;
	  }

	  public HttpStatus getHttpStatus() {
	    return httpStatus;
	  }
}
