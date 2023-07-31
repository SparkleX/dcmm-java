package com.next.dcmm.lcm.init;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class TableService {
	@Value("classpath:table/*.table.json")
	private Resource[] resources;

    @Autowired
    private ResourceLoader resourceLoader;

	public String list() throws Exception {
		for (final Resource res : resources) {
			System.out.println(res.getFilename());
	        try (InputStream inputStream = res.getInputStream()) {
	            String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
	            System.out.println(text);
	        }

		}
		return "blog/a";
	}
}
