package com.next.dcmm.framework.compiler.sql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.dcmm.framework.schema.mapper.Mapper;
import com.next.dcmm.framework.schema.table.Table;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.StringWriter;
import java.util.HashMap;

@Component
public class SqlCompiler {
    @Value(value = "${folder.resources}")
    String resourcesFolder;
    @Value(value = "${folder.output}")
    String outputFilder;
    String tableResourceFolder;
    String sqlResourceFolder;

    String sourceCodeFolder;


    public void run(String[] args) throws Exception {
        sqlResourceFolder = resourcesFolder + File.separator + "sql";
        tableResourceFolder = resourcesFolder + File.separator + "table";
        sourceCodeFolder =  outputFilder + File.separator + "java" + File.separator + "gen"+ File.separator + "mapper";

        File f = new File(sqlResourceFolder);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".sql.json");
            }
        };

        String[] paths = f.list(filter);

        for (String file : paths) {
            this.generate(file);
        }
    }

    @Autowired
    SqlTemplate template;

    void generate(String fileName) throws Exception {
        System.out.println(fileName);

        ObjectMapper mapper = new ObjectMapper();
        String fullFileName = sqlResourceFolder + File.separator + fileName;

        File file = new File(fullFileName);
        Mapper oMapper = mapper.readValue(file, Mapper.class);
        String name = fileName.split("\\.")[0];
        
        String tableFile = tableResourceFolder + File.separator + name + ".table.json";
        Table oTable = mapper.readValue(new File(tableFile), Table.class);

        HashMap<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("data", oMapper);
        String sqlInsert = sqlInsert(oTable);
        data.put("sqlInsert", sqlInsert);
        String sqlUpdate = sqlUpdate(oTable);

        data.put("sqlUpdate", sqlUpdate);
        StringWriter sw = new StringWriter();
        this.template.getTemplate().process(data, sw);
        String filePath = sourceCodeFolder + File.separator + name + "Mapper.java";
        FileUtils.writeStringToFile(new File(filePath), sw.toString(), "utf8");
    }
    private String sqlUpdate(Table oTable) {
    	StringBuilder sbParams = new StringBuilder();
    	for(String field:oTable.fields.keySet()) {
    		sbParams.append(field).append("=#{").append(field).append("},");
    	}
    	sbParams.setLength(sbParams.length()-1);

    	return String.format("update %s set %s where NodeId = #{NodeId}", oTable.name, sbParams.toString());
	}
    private String sqlInsert(Table oTable) {
    	StringBuilder sbFields = new StringBuilder();
    	StringBuilder sbParams = new StringBuilder();
    	for(String field:oTable.fields.keySet()) {
    		sbFields.append(field).append(",");
    		sbParams.append("#{").append(field).append("},");
    	}
    	sbFields.setLength(sbFields.length()-1);
    	sbParams.setLength(sbParams.length()-1);
    	return String.format("insert into %s(%s) values(%s)", oTable.name, sbFields.toString(), sbParams.toString());
    }
}
