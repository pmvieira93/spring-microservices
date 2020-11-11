package pt.sample.ms.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("pt.sample.ms")
@SpringBootApplication
public class SpringMsProductcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProductcatalogApplication.class, args);
	}

}
