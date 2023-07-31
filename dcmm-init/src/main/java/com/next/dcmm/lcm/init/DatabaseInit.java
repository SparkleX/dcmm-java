
package com.next.dcmm.lcm.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DatabaseInit {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext appCtx = SpringApplication.run(DatabaseInit.class, args);
        DatabaseInit inst = appCtx.getBean(DatabaseInit.class);
        inst.run(args);
    }

    @Autowired
    TableService tableService;
    private void run(String[] args) throws Exception {
    	tableService.list();
    }
}
