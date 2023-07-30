package com.next.dcmm.framework;

public interface BaseDao<MODEL> {
	MODEL find(Integer id);
	void insert(MODEL foo);
	boolean update(MODEL foo);
	boolean delete(int id);
}
