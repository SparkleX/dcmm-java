package com.next.dcmm.framework.schema.table;

import java.util.List;
import java.util.Map;

public class Table {
    public String name;

    public Map<String, Field> fields;
    public String getName() {
        return name;
    }
    public Map<String, Field> getFields() {
        return fields;
    }
    public List<String> fieldsOrder;
}
