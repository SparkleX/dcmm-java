package dcmm.metadata.list;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next.dcmm.framework.schema.choose.Choose;

@Service
public class ChooseService {

	
	@Autowired
	ResourceLoader resourceLoader;
	public Choose getChooseFromList(String table) throws Exception {
		String path = String.format("classpath:choose/%s.choose.json", table);
		Resource resource = resourceLoader.getResource(path);
		InputStream inputStream = resource.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Choose data = mapper.readValue(inputStream, Choose.class);
		return data;
	}

}
