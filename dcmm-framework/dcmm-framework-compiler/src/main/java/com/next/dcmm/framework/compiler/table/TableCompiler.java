package com.next.dcmm.framework.compiler.table;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.dcmm.framework.schema.table.Table;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;


// --folder.source=/Users/i031684/eclipse-workspace/dcmm/dcmm-resources/src/main/resources/table
@Component
public class TableCompiler {
    @Value(value = "${folder.resources}")
    String resourcesFolder;
    @Value(value = "${folder.output}")
    String outputFilder;
    String tableResourceFolder;
    String sourceCodeFolder;


    public void run(String[] args) throws Exception {
        tableResourceFolder = resourcesFolder + File.separator + "table";
        sourceCodeFolder =  outputFilder + File.separator + "java" + File.separator + "gen"+ File.separator + "model";

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

        //HashMap<String, Object> map = new HashMap<>();
        // Set<String> virtualColumn = tbl.getVirtualColumns().stream()
        //       .map(MetaColumn::getColumnName)
        //     .collect(Collectors.toSet());
        //map.put("data", tbl);
        //map.put("pks", pks);
        //map.put("virtualColumn", virtualColumn);
        StringWriter sw = new StringWriter();
        this.template.getTemplate().process(oTable, sw);
        String filePath = sourceCodeFolder + File.separator + oTable.name + "Model.java";
        FileUtils.writeStringToFile(new File(filePath), sw.toString(), "utf8");
    }
}
