package gen.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.next.dcmm.framework.BaseDao;

import gen.model.ORDR1Model;


public interface ORDR1Dao extends BaseDao<ORDR1Model> {
  
  @Select("select * from foo where NodeId=#{id}")
  ORDR1Model find(Integer id);

  @Insert("insert into foo (NodeId, Data) values(#{NodeId}, #{Data})")
  void insert(ORDR1Model data);
  
  @Update("update foo set Data = #{Data} where NodeId = #{NodeId}")
  boolean update(ORDR1Model foo);
  
  @Delete("delete from foo where NodeId = #{id}")
  boolean delete(ORDR1Model id);
}