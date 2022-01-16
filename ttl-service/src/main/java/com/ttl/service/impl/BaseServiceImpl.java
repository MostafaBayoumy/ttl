/**
 * 
 */
package com.ttl.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ttl.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttl.model.BaseEntity;
import com.ttl.model.exception.BusinessException;
import com.ttl.service.BaseService;

/**
 * @createdBy: Moustafa.Bayoumy
 * @createdOn: Jul 14, 2020 - 8:45:08 PM
 *
 */
@Service
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable>
		implements BaseService<T, ID> {

	@Autowired
	private BaseRepository<T, ID> baseRepository;


	@Override
	@Transactional
	public T save (T entity) throws BusinessException {
		return baseRepository.save(entity);
	}
	
	@Override
	@Transactional
	public Boolean deleteById(ID id) throws BusinessException {
		baseRepository.deleteById(id);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public T getById(ID id) throws BusinessException {
		return baseRepository.getOne(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<T> findAll() throws BusinessException {
		return baseRepository.findAll();
	}
	
}
