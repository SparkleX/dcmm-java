package example.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;

import example.foo.Filter;
import example.foo.FilterSqlProvider;
import gen.dao.FooDao;
import gen.model.FooModel;

@Mapper
public interface FooMapper extends FooDao {

  @Select("select * from foo")
  FooModel findByState(@Param("state") String state);
  
  
  //@SelectProvider(type=FilterSqlProvider.class, method = "filter")
  @Select("SELECT @@transaction_ISOLATION;")
  //@ResultType(Map.class)
  List<Map<String,Object>> findAll(Filter filter);
  //List<Map<String,Object>> findAll(Filter filter);
  //@Select("${sql}")
  //List<FooModel> findAll(HashMap<String, Object> m);
  
  
  @Select("select * from foo where NodeId=#{id}")
  FooModel find(Integer id);

  @Insert("insert into foo (NodeId, Data) values(#{NodeId}, #{Data})")
  void insert(FooModel data);
  
  @Update("update foo set Data = #{Data} where NodeId = #{NodeId}")
  boolean update(FooModel foo);
  
  @Delete("delete from foo where NodeId = #{id}")
  boolean delete(Integer id);
}