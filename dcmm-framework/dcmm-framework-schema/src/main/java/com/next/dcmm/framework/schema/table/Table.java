package com.next.dcmm.framework.schema.table;

import java.util.List;
import java.util.Map;

public class Table {
    public String getName() {
		return name;
	}
	public Map<String, Field> getFields() {
		return fields;
	}
	public Map<String, String> getArrayTables() {
		return arrayTables;
	}
	public List<String> getFieldsOrder() {
		return fieldsOrder;
	}
	public String name;
    public Map<String, Field> fields;
	public Map<String, String> arrayTables;
    public List<String> fieldsOrder;


}
