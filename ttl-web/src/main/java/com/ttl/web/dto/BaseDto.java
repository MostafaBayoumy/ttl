/**
 * 
 */
package com.ttl.web.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @createdBy: Moustafa.Bayoumy
 * @createdOn: Jul 14, 2020 - 10:14:34 PM
 *
 */
@Data
public class BaseDto<ID extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8372024569764349169L;
	
	private ID id;

}
