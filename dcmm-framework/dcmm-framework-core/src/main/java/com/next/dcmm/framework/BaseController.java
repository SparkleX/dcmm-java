package com.next.dcmm.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseController<T,DAO extends BaseDao<T>,SVC extends BaseService<T,DAO>> {
	
	@Autowired
	protected SVC service;
	
	@GetMapping("/data/{id}")
	public T findById(@PathVariable Integer id) {
		T data = service.findById(id);
		return data;
	}
	@PostMapping("/data")
	public Integer create(@RequestBody T data) {
		Integer id = service.create(data);
		return id;
	}
	@PutMapping("/data/{id}")
	public void update(@PathVariable Integer id, @RequestBody T data) {
		service.update(id, data);
	}
	@DeleteMapping("/data/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
