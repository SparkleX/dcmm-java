package com.next.dcmm.framework.schema.table;

public class Field {
	
	public final static String FieldTypeUuid = "uuid";
	public final static String FieldTypeString = "string";
	public final static String FieldTypeText = "text";
	public final static String FieldTypeNumber = "number";
	public final static String FieldTypeDecimal = "decimal";
	public final static String FieldTypeDate = "date";
	public final static String FieldTypeTime = "time";


    public String type;
    public Integer size;
    public String codes;

    public String getType() {
        return type;
    }

    public Integer getSize() {
        return size;
    }

    public String getCodes() {
        return codes;
    }
}
