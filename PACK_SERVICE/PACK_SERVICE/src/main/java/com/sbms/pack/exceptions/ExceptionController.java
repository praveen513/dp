package com.sbms.pack.exceptions;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author DPraveen
 *
 */
@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NotFoundException.class)
	public void notFoundexception(HttpServletResponse res, NotFoundException ex) throws IOException {
		res.sendError(ex.getHttpStatus().value(), ex.getMessage());
	}

	@ExceptionHandler(BadRequestException.class)
	public void badRequestException(HttpServletResponse res, BadRequestException ex) throws IOException {
		res.sendError(ex.getHttpStatus().value(), ex.getMessage());
	}

	@ExceptionHandler(ApplicationException.class)
	public void applicationException(HttpServletResponse res, ApplicationException ex) throws IOException {
		res.sendError(ex.getHttpStatus().value(), ex.getMessage());
	}

}
