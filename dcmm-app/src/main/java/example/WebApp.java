package example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("gen.dao")
public class WebApp {
	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);

	}
}
