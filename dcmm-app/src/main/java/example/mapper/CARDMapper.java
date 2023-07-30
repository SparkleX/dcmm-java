package example.mapper;

import java.util.List;
import java.util.Map;

import gen.dao.CARDDao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import example.card.Filter;
import gen.model.CARDModel;

@Mapper
public interface CARDMapper extends CARDDao {

  @Select("select * from foo")
  CARDModel findByState(@Param("state") String state);
  
  
  //@SelectProvider(type=FilterSqlProvider.class, method = "filter")
  @Select("SELECT @@transaction_ISOLATION;")
  //@ResultType(Map.class)
  List<Map<String,Object>> findAll(Filter filter);
  //List<Map<String,Object>> findAll(Filter filter);
  //@Select("${sql}")
  //List<FooModel> findAll(HashMap<String, Object> m);
  
  
  @Select("select * from foo where NodeId=#{id}")
  CARDModel find(Integer id);

  @Insert("insert into foo (NodeId, Data) values(#{NodeId}, #{Data})")
  void insert(CARDModel data);
  
  @Update("update foo set Data = #{Data} where NodeId = #{NodeId}")
  boolean update(CARDModel foo);
  
  @Delete("delete from foo where NodeId = #{id}")
  boolean delete(Integer id);
}