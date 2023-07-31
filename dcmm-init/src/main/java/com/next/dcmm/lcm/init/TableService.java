package com.next.dcmm.lcm.init;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.dcmm.framework.schema.table.Table;

@Component
public class TableService {
	@Value("classpath:table/*.table.json")
	private Resource[] resources;

    //@Autowired
    //private ResourceLoader resourceLoader;

    @Autowired
    private DdlBuilder ddlBuilder;
    
	public List<String> createSqls() throws Exception {
		List<String> sqls = new ArrayList<String>();
		for (final Resource res : resources) {
			System.out.println(res.getFilename());
	        try (InputStream inputStream = res.getInputStream()) {
	            //String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
	            ObjectMapper mapper = new ObjectMapper();
	            Table oTable = mapper.readValue(inputStream, Table.class);
	            String sql = ddlBuilder.createTable(oTable);
	            sqls.add(sql);
	        }
		}
		return sqls;
	}
}
