package com.next.dcmm.framework.compiler;

import com.next.dcmm.framework.compiler.sql.SqlCompiler;
import com.next.dcmm.framework.compiler.table.TableCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext appCtx = SpringApplication.run(MainApp.class, args);
        MainApp inst = appCtx.getBean(MainApp.class);
        inst.run(args);
    }

    @Autowired
    TableCompiler tableCompiler;
    @Autowired
    SqlCompiler sqlCompiler;
    private void run(String[] args) throws Exception {
        tableCompiler.run(args);
        sqlCompiler.run(args);
    }
}
