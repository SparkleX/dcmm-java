package gen.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.next.dcmm.framework.BaseDao;

import gen.model.ORDRModel;


public interface ORDRDao extends BaseDao<ORDRModel> {
  
  @Select("select * from foo where NodeId=#{id}")
  ORDRModel find(Integer id);

  @Insert("insert into foo (NodeId, Data) values(#{NodeId}, #{Data})")
  void insert(ORDRModel data);
  
  @Update("update foo set Data = #{Data} where NodeId = #{NodeId}")
  boolean update(ORDRModel foo);
  
  @Delete("delete from foo where NodeId = #{id}")
  boolean delete(Integer id);
}