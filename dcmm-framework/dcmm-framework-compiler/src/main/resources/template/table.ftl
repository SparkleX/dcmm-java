package gen.model;
import com.next.dcmm.framework.BaseModel;
import java.math.BigDecimal;
@SuppressWarnings("all")
public class ${name}Model extends BaseModel{
<#list fields as fieldName, field>
	<#if fieldName == "NodeId">
		<#continue>
	</#if>
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
