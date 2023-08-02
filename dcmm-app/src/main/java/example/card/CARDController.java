package example.card;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.dcmm.framework.BaseController;

import gen.mapper.CARDMapper;
import gen.model.CARDModel;

@RestController
@RequestMapping(path="/CARD")
public class CARDController extends BaseController<CARDModel, CARDMapper, CARDService>{



}