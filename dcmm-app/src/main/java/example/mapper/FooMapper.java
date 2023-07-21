package example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import gen.dao.FooDao;
import gen.model.FooModel;

@Mapper
public interface FooMapper extends FooDao {

  @Select("select * from foo")
  FooModel findByState(@Param("state") String state);
  
  @Select("select * from foo where NodeId=#{id}")
  FooModel find(Integer id);

  @Insert("insert into foo (NodeId, Data) values(#{NodeId}, #{Data})")
  void insert(FooModel data);
  
  @Update("update foo set Data = #{Data} where NodeId = #{NodeId}")
  boolean update(FooModel foo);
  
  @Delete("delete from foo where NodeId = #{id}")
  boolean delete(Integer id);
}