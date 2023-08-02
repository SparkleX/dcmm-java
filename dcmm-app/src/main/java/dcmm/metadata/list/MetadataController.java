package dcmm.metadata.list;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.dcmm.framework.schema.choose.Choose;
import com.next.dcmm.framework.schema.list.ListView;

@RestController
@RequestMapping(path="/metadata")
public class MetadataController {
	@Autowired
	ListService listService;
	@Autowired
	ChooseService chooseService;
	
	@GetMapping("/list/{table}")
	public ListView getListView(@PathVariable String table) throws Exception {
		ListView data = listService.getListView(table);
		return data;
	}
	
	@GetMapping("/choose/{table}")
	public Choose getChooseFromList(@PathVariable String table) throws Exception {
		Choose data = chooseService.getChooseFromList(table);
		return data;
	}
}
