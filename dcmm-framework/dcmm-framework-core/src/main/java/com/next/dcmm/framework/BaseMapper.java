package com.next.dcmm.framework;

import java.util.List;

public interface BaseMapper<MODEL> {
	List<MODEL> findAll();
	MODEL find(String id);
	void insert(MODEL foo);
	boolean update(MODEL foo);
	boolean delete(String id);
}
