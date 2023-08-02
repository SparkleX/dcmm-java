package com.next.dcmm.framework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController<T extends BaseModel,DAO extends BaseMapper<T>,SVC extends BaseService<T,DAO>> {
	
	@Autowired
	protected SVC service;
	
	@GetMapping("/data")
	public List<T> findAll() {
		List<T> data = service.findAll();
		return data;
	}
	@GetMapping("/data/{id}")
	public T findById(@PathVariable String id) {
		T data = service.findById(id);
		return data;
	}
	@PostMapping("/data")
	public String create(@RequestBody T data) throws JsonProcessingException {
		String id = service.create(data);
		ObjectMapper om = new ObjectMapper();
		String rt = om.writeValueAsString(id);
		return rt;
	}
	@PutMapping("/data/{id}")
	public ResponseEntity<String> update(@PathVariable String id, @RequestBody T data) {
		service.update(id, data);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/data/{id}")
	public ResponseEntity<String>  delete(@PathVariable String id) {
		service.delete(id);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
}
