/**
 * 
 */
package com.ttl.web.response;

import org.springframework.http.HttpStatus;

/**
 * @createdBy: Moustafa.Bayoumy
 * @createdOn: Jul 14, 2020 - 10:13:49 PM
 *
 */
public final class ErrorResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6288759437248407410L;

	private String message;
	
	public ErrorResponse(String message) {
		super(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR.value());
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
