package dcmm.metadata.list;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.dcmm.framework.schema.list.ListView;

@Service
public class ListService {

	
	@Autowired
	ResourceLoader resourceLoader;
	public ListView getListView(String table) throws Exception {
		String path = String.format("classpath:list/%s.list.json", table);
		Resource resource = resourceLoader.getResource(path);
		InputStream inputStream = resource.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        ListView data = mapper.readValue(inputStream, ListView.class);
		return data;
	}

}
