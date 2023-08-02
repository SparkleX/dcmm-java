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

	@Select("select * from ${name}")
	List<${name}Model> findAll();
	@Select("select * from ${name} where NodeId=${r"#{id}"}")
	${name}Model find(String id);

    @Insert("${sqlInsert}")
	void insert(${name}Model data);
	@Update("${sqlUpdate}")
	int update(${name}Model data);
	@Delete("delete from ${name} where NodeId=${r"#{NodeId}"}")
	int delete(String id);
}
