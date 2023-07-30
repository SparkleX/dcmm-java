package gen.model;
import java.math.BigDecimal;
@SuppressWarnings("all")
public class ${name}Model {
<#list fields as fieldName, field>
    <#switch field.type>
        <#case "uuid">
    public String ${fieldName};
        <#break>
        <#case "string">
    public String ${fieldName};
        <#break>
        <#case "decimal">
    public BigDecimal ${fieldName};
        <#break>
        <#default>
     public String ${fieldName};
    </#switch>
</#list>
}
