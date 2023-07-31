package com.next.dcmm.framework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BaseService<T extends BaseModel, DAO extends BaseMapper<T>> {
	@Autowired
	protected DAO dao;

	
	public List<T> findAll() {
		List<T> data = dao.findAll();
		return data;
	}
	
	public T findById(String id) {
		T data = dao.find(id);
		return data;
	}
	@Transactional
	public String create(T data) {
		dao.insert(data);
		return data.NodeId;
	}
	@Transactional
	public void update(String id, T data) {
		data.NodeId = id;
		int rt = dao.update(data);
		if(rt!=1) {
			throw new RuntimeException("delete failed");
		}
	}
	@Transactional
	public void delete(String id) {
		int rt = dao.delete(id);
		if(rt!=1) {
			throw new RuntimeException("delete failed");
		}
	}
}
