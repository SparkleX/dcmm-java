package example.foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dcmm.framework.BaseService;
import com.next.dcmm.framework.SqlTransaction;

import gen.dao.FooDao;
import gen.model.FooModel;

@Service
public class FooService extends BaseService<FooModel, FooDao> {

	@Autowired
	FooDao mapper;
	
	//@Transactional
	@SqlTransaction
	public FooModel function1(String p1, String p2) {
		
		FooModel data = new FooModel();
		data.NodeId = 4;
		data.Data = "c";
		mapper.insert(data);
		/*data.NodeId = 2;
		data.Data = "c";
		mapper.insert(data);*/
		//String rt = "abc";
		return data;
	}
	
	
}