package com.next.dcmm.lcm.init;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.next.dcmm.framework.schema.table.Field;
import com.next.dcmm.framework.schema.table.Table;

@Component
public class DdlBuilder {
    
	private void initFieldsOrder(Table table) {
		table.fieldsOrder = new ArrayList<String>();
		for (String field:table.fields.keySet()) {
			table.fieldsOrder.add(field);
		}
	}
	private String fieldType(Field field) {
		switch(field.type) {
		case Field.FieldTypeUuid:
			return "varchar(40)";
		case Field.FieldTypeString:
			return String.format("nvarchar(%d)",field.size);
		case Field.FieldTypeText:
			return "text";
		case Field.FieldTypeNumber:
			return "int";
		case Field.FieldTypeDecimal:
			return "decimal";
		case Field.FieldTypeDate:
			return "datetime";
		case Field.FieldTypeTime:
			return "datetime";
		}
		return null;
	}
	public String createTable(Table table) {
		this.initFieldsOrder(table);
		StringBuilder temp = new StringBuilder();
		
		for (String field:table.fieldsOrder) {
			Field oField = table.fields.get(field);
			String fieldType = fieldType(oField);
			temp.append(field).append(" ").append(fieldType).append(",");
		}
		//temp.setLength(temp.length() - 1);
		String sql = String.format("create table %s ( %s primary key (NodeId))", table.name, temp.toString());
		return sql;
	}
}
