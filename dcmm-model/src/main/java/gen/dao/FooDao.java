package gen.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.next.dcmm.framework.BaseDao;

import gen.model.FooModel;


public interface FooDao extends BaseDao<FooModel> {

  @Select("select * from foo where NodeId=#{id}")
  FooModel find(Integer id);

  @Insert("insert into foo (NodeId, Data) values(#{NodeId}, #{Data})")
  void insert(FooModel data);
  
  @Update("update foo set Data = #{Data} where NodeId = #{NodeId}")
  boolean update(FooModel foo);
  
  @Delete("delete from foo where NodeId = #{id}")
  boolean delete(Integer id);
}