package com.next.dcmm.framework;

import org.apache.el.util.ReflectionUtil;

import java.lang.reflect.Field;

public class BaseModel {
	static final  String NODE_ID = "NodeId";
	public static <T> void setNodeId(T data, Integer id) {
		try {
			Field field = data.getClass().getDeclaredField(NODE_ID);
			field.set(data, id);
		}catch (Exception ex ) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public static <T> Integer getNodeId(T data) {
		try {
			Field field = data.getClass().getDeclaredField(NODE_ID);
			Object rt = field.get(data);
			return (Integer)rt;
		}catch (Exception ex ) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
