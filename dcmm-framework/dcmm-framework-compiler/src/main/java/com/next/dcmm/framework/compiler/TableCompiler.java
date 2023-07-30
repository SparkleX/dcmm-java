package com.next.dcmm.framework.compiler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.dcmm.framework.schema.table.Table;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.*;
import java.util.HashMap;

import java.util.Set;


// --folder.source=/Users/i031684/eclipse-workspace/dcmm/dcmm-resources/src/main/resources/table
@SpringBootApplication
public class TableCompiler {
    @Value(value = "${folder.resources}")
    String resourcesFolder;
    @Value(value = "${folder.output}")
    String outputFilder;
    String tableResourceFolder;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext appCtx = SpringApplication.run(TableCompiler.class, args);
        TableCompiler inst = appCtx.getBean(TableCompiler.class);
        inst.run(args);
    }

    private void run(String[] args) throws Exception {
        tableResourceFolder = resourcesFolder + File.separator + "table";
        File f = new File(tableResourceFolder);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".table.json");
            }
        };

        String[] paths = f.list(filter);

        for (String file : paths) {
            this.generate(file);
        }
    }

    @Autowired
    TableTemplate template;

    void generate(String fileName) throws Exception {
        System.out.println(fileName);

        ObjectMapper mapper = new ObjectMapper();
        String fullFileName = tableResourceFolder + File.separator + fileName;

        File file = new File(fullFileName);
        Table oTable = mapper.readValue(file, Table.class);

        HashMap<String, Object> map = new HashMap<>();
        // Set<String> virtualColumn = tbl.getVirtualColumns().stream()
        //       .map(MetaColumn::getColumnName)
        //     .collect(Collectors.toSet());
        //map.put("data", tbl);
        //map.put("pks", pks);
        //map.put("virtualColumn", virtualColumn);
        StringWriter sw = new StringWriter();
        this.template.getTemplate().process(oTable, sw);
        String filePath = outputFilder + File.separator + oTable.name + "Model.java";
        FileUtils.writeStringToFile(new File(filePath), sw.toString(), "utf8");
    }
}
