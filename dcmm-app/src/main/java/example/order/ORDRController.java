package example.order;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.dcmm.framework.BaseController;

import example.mapper.ORDRMapper;
import gen.model.ORDRModel;

@RestController
@RequestMapping(path="/ORDR")
public class ORDRController extends BaseController<ORDRModel, ORDRMapper, ORDRService>{


}