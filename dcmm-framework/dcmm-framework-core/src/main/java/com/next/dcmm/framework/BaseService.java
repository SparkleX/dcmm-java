package com.next.dcmm.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BaseService<T extends BaseModel, DAO extends BaseDao<T>> {
	@Autowired
	protected DAO dao;
	
	public T findById(Integer id) {
		T data = dao.find(id);
		return data;
	}
	@Transactional
	public Integer create(T data) {
		dao.insert(data);
		return data.NodeId;
	}
	@Transactional
	public void update(Integer id, T data) {
		data.NodeId = id;
		dao.update(data);
	}
	@Transactional
	public void delete(Integer id) {
		dao.delete(id);
	}
}
