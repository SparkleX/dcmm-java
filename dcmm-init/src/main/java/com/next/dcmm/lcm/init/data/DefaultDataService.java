package com.next.dcmm.lcm.init.data;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.dcmm.framework.schema.table.Table;

@Component
public class DefaultDataService {
	@Value("classpath:data/*.data.json")
	private Resource[] resources;
	
	public void insertAll() throws Exception {
		List<String> sqls = new ArrayList<String>();
		for (final Resource res : resources) {
			System.out.println(res.getFilename());
	        try (InputStream inputStream = res.getInputStream()) {
	            ObjectMapper mapper = new ObjectMapper();
	            List<Map<String,Object>> data = mapper.readValue(inputStream, List.class);
	            String tableName = res.getFilename().split("\\.")[0];
	            for(Map<String,Object> row:data) {
	            	this.insert(tableName, row);
	            }
	        }
		}
	}
    @Autowired
    JdbcTemplate jdbcTemplate;
	private void insert(String tableName, Map<String, Object> row) {
		
	   	StringBuilder sbFields = new StringBuilder();
	   	StringBuilder sbParams = new StringBuilder();

    	List<Object> params = new ArrayList<Object>();
    	for(String field:row.keySet()) {
    		sbFields.append(field).append(",");
    		sbParams.append("?,");

    		params.add(row.get(field));
    	}
    	sbFields.setLength(sbFields.length()-1);
    	sbParams.setLength(sbParams.length()-1);

    	String sql = String.format("insert into %s(%s) values(%s)", tableName, sbFields.toString(), sbParams.toString());
    	Object[] p = params.toArray();
    	jdbcTemplate.update(sql, p);
		
	}
}
