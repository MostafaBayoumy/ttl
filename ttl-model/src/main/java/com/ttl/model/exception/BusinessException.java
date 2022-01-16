/**
 * 
 */
package com.ttl.model.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @createdBy: Moustafa.Bayoumy
 * @createdOn: Jul 14, 2020 - 5:58:47 PM
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -278703955810731321L;

	private List<String> errorCodes;

	public BusinessException() {
		
	}
	
	public BusinessException(String errorCode) {
		this(errorCode, null);
	}

	public BusinessException(String errorCode, Throwable th) {
		super(errorCode, th);
		addErrorCode(errorCode);
	}

	public List<String> getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(List<String> errorCodes) {
		this.errorCodes = errorCodes;
	}
	
	public void addErrorCode(String errorCode) {
		if(errorCodes == null)
		{
			errorCodes = new ArrayList<String>();
		}
		errorCodes.add(errorCode);
	}

}
