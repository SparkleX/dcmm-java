package example.foo;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.dcmm.framework.BaseController;

import gen.dao.FooDao;
import gen.model.FooModel;

@RestController
@RequestMapping(path="/foo")
public class FooController extends BaseController<FooModel, FooDao, FooService>{

	
	@GetMapping("/test/{p1}/{p2}")
	public FooModel findAll(@PathVariable String p1, @PathVariable String p2 ){
		FooModel rt = service.function1(p1, p2);
		return rt;
	}
}