
package com.next.dcmm.lcm.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.next.dcmm.lcm.init.data.DefaultDataService;

@SpringBootApplication
public class DatabaseInit {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext appCtx = SpringApplication.run(DatabaseInit.class, args);
        DatabaseInit inst = appCtx.getBean(DatabaseInit.class);
        inst.run(args);
    }

    @Autowired
    TableService tableService;
    @Autowired
    DefaultDataService dataService;
    @Autowired
    JdbcTemplate jdbcTemplate;
    private void run(String[] args) throws Exception {
    	List<String> sqls = tableService.createSqls();
    	for(String sql:sqls) {
    		System.out.println(sql);
    		jdbcTemplate.execute(sql);
    	}
    	dataService.insertAll();
    }
}
