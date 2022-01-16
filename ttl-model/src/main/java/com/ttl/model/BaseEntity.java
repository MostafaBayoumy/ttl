/**
 * 
 */
package com.ttl.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.*;

/**
 * @createdBy: Moustafa.Bayoumy
 * @createdOn: Jul 14, 2020 - 5:58:19 PM
 *
 */
@MappedSuperclass
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4480593017607392798L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

}
