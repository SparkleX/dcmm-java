package dcmm.item;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.dcmm.framework.BaseController;

import gen.mapper.ITEMMapper;
import gen.model.ITEMModel;

@RestController
@RequestMapping(path="/ITEM")
public class ITEMController extends BaseController<ITEMModel, ITEMMapper, ITEMService>{



}