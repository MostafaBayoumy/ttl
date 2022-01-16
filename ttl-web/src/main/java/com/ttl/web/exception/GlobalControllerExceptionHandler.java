package com.ttl.web.exception;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ttl.web.response.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ttl.model.exception.BusinessException;
import com.ttl.web.response.BaseResponse;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger(GlobalControllerExceptionHandler.class);

	
	@ExceptionHandler(value = SQLException.class)
	public @ResponseBody BaseResponse handle(HttpServletRequest req, SQLException ex) {
		logException(ex);
		return new ErrorResponse(ex.getMessage());
	}
	
	@ExceptionHandler(value = BusinessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse handleBusinessException(HttpServletRequest req, BusinessException ex) {
		logException(ex);
		LOGGER.info(ex.getMessage());
		return new ErrorResponse(ex.getMessage());
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse handleException(HttpServletRequest req, Exception ex) {
		logException(ex);
		return new ErrorResponse(ex.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody BaseResponse handleMethodArgumentException(HttpServletRequest req, Exception ex) {
		
		logException(ex);
		
		StringBuilder sb = new StringBuilder();
		List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			sb.append(fieldError.getDefaultMessage());
			sb.append(";");
		}
		return new ErrorResponse(sb.toString());
	}
	
	
	private void logException(Throwable th)
	{
		String errorMessage = th.getMessage();
		
		if(th.getStackTrace() != null)
		{
			LOGGER.error(errorMessage, th);
		}
		else
		{
			LOGGER.error(errorMessage);
		}
	}

}