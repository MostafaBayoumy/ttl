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
public class SuccessResponse<T> extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -204251348685583281L;
	
	private T data;
	
	public SuccessResponse(T result) {
		super(Boolean.TRUE, HttpStatus.OK.value());
		this.data = result;
	}
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
}
