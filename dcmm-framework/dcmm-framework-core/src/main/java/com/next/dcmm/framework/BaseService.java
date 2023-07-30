package com.next.dcmm.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BaseService<T, DAO extends BaseMapper<T>> {
	@Autowired
	protected DAO dao;
	
	public T findById(Integer id) {
		T data = dao.find(id);
		return data;
	}
	@Transactional
	public Integer create(T data) {
		dao.insert(data);
		Integer id = BaseModel.getNodeId(data);
		return id;
	}
	@Transactional
	public void update(Integer id, T data) {
		BaseModel.setNodeId(data, id);
		dao.update(data);
	}
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}
}
