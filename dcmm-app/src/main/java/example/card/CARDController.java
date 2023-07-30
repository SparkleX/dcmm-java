package example.card;



import gen.mapper.CARDMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.dcmm.framework.BaseController;

import gen.model.CARDModel;

@RestController
@RequestMapping(path="/foo")
public class CARDController extends BaseController<CARDModel, CARDMapper, CARDService>{

	
	@GetMapping("/query")
	public Object findAll(){
		Object rt = service.findAll();
		return rt;
	}
	
	@GetMapping("/test/{p1}/{p2}")
	public CARDModel findAll(@PathVariable String p1, @PathVariable String p2 ){
		CARDModel rt = service.function1(p1, p2);
		return rt;
	}
}