package gen.mapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.next.dcmm.framework.BaseMapper;

import gen.model.${name}Model;

@SuppressWarnings("all")

@Mapper
public interface ${name}Mapper extends BaseMapper<${name}Model> {
<#list data as methodName, method>
    @Select("${method.sql}")
    ${method.returnType} ${methodName}(
    <#list method.params as paramName, paramType>
        ${paramType} ${paramName}<#if (paramName_has_next)>,</#if>
    </#list>
    );
</#list>

}
