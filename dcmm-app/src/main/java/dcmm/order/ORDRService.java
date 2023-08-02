package dcmm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.next.dcmm.framework.BaseService;

import gen.model.ORDRModel;
import gen.mapper.ORDRMapper;
import gen.mapper.ORDR1Mapper;

@Service
public class ORDRService extends BaseService<ORDRModel, ORDRMapper> {
	
	@Autowired
	ORDR1Mapper daoORDR1;
	
	@Transactional
	public String create(ORDRModel data) {
		String rt = super.create(data);
		return rt;
	}
	
	
}