package example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.next.dcmm.framework.BaseService;

import example.mapper.ORDR1Mapper;
import example.mapper.ORDRMapper;
import gen.model.ORDRModel;

@Service
public class ORDRService extends BaseService<ORDRModel, ORDRMapper> {
	
	@Autowired
	ORDR1Mapper daoORDR1;
	
	@Transactional
	public Integer create(ORDRModel data) {
		Integer rt = super.create(data);
		return rt;
	}
	
	
}