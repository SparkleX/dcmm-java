package dcmm.order;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dcmm.framework.BaseService;

import gen.mapper.ORDR1Mapper;
import gen.mapper.ORDRMapper;
import gen.model.ORDR1Model;
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
		int lineNum = 0;
		for (ORDR1Model drDOC1:data.DOC1) {
			drDOC1.NodeId = UUID.randomUUID().toString();
			drDOC1.ParentId = rt;
			drDOC1.LineNum = lineNum;
			lineNum++;
			daoORDR1.insert(drDOC1);
		}
		return rt;
	}
	
	@Override
	public void update(String id, ORDRModel data) {
		super.update(id, data);
		int lineNum = 0;
		for (ORDR1Model drDOC1:data.DOC1) {
			drDOC1.ParentId = id;
			drDOC1.LineNum = lineNum;
			lineNum++;
			if(drDOC1.NodeId == null) {
				drDOC1.NodeId = UUID.randomUUID().toString();
				daoORDR1.insert(drDOC1);
			} else {				
				daoORDR1.update(drDOC1);
			}
			
		}
	}
	
	@Override
	public void delete(String id) {
		super.delete(id);
		this.daoORDR1.deleteByParent(id);
	}
}