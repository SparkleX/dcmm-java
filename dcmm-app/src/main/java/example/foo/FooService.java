package example.foo;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.next.dcmm.framework.BaseService;
import com.next.dcmm.framework.SqlTransaction;

import example.mapper.FooMapper;
import gen.model.FooModel;

@Service
public class FooService extends BaseService<FooModel, FooMapper> {
	
	public Object findAll() {
		Filter filter = new Filter();
		//filter.params.put("id", 1);
		//FooResultHandler handle = new FooResultHandler();
		//super.dao.findAll(filter,handle);
		//Object rt = handle.getData();
		
		//String sql = "select * from foo where NodeId = #{id}";
		//HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("sql", sql);
		//map.put("id", Integer.valueOf(1));
		//Object rt = super.dao.findAll(map);
		Object rt = super.dao.findAll(filter);
		return rt;
	}
	
	//@Transactional
	@SqlTransaction
	public FooModel function1(String p1, String p2) {
		
		FooModel data = new FooModel();
		data.NodeId = 4;
		data.Data = "c";
		super.dao.insert(data);
		/*data.NodeId = 2;
		data.Data = "c";
		mapper.insert(data);*/
		//String rt = "abc";
		return data;
	}
	
	
}