package gen.dao;


import com.next.dcmm.framework.BaseDao;
import gen.model.CARDModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface CARDDao extends BaseDao<CARDModel> {
  
  @Select("select * from foo where NodeId=#{id}")
  CARDModel find(Integer id);

  @Insert("insert into foo (NodeId, Data) values(#{NodeId}, #{Data})")
  void insert(CARDModel data);
  
  @Update("update foo set Data = #{Data} where NodeId = #{NodeId}")
  boolean update(CARDModel foo);
  
  @Delete("delete from foo where NodeId = #{id}")
  boolean delete(Integer id);
}