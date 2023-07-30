package com.next.dcmm.framework.schema.mapper;

import java.util.HashMap;
import java.util.Map;

public class Query {
    public String sql;
    public String returnType;

    public Map<String, String> params;
    public String getSql() {
        return sql;
    }

    public String getReturnType() {
        return returnType;
    }

    public Map<String, String> getParams() {
        return params;
    }

}
