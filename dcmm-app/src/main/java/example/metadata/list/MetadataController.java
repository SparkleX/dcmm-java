package example.metadata.list;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.dcmm.framework.schema.list.ListView;

@RestController
@RequestMapping(path="/metadata")
public class MetadataController {
	@Autowired
	ListService listService;
	
	@GetMapping("/list/{table}")
	public ListView getListView(@PathVariable String table) throws Exception {
		ListView data = listService.getListView(table);
		return data;
	}
}
