package dcmm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dcmm.framework.BaseService;

import gen.mapper.ORDR1Mapper;
import gen.mapper.ORDRMapper;
import gen.model.ORDRModel;

@Service
public class ORDRService extends BaseService<ORDRModel, ORDRMapper> {
	
	@Autowired
	ORDR1Mapper daoORDR1;
	
	
	public ORDRModel findById(String id) {
		ORDRModel data = super.findById(id);
		data.DOC1 = daoORDR1.findByParent(id);
		return data;
	}
	
	@Override
	public String create(ORDRModel data) {
		String rt = super.create(data);
		return rt;
	}
	
	
}