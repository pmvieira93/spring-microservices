package pt.sample.ms.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"pt.sample.ms"})
@SpringBootApplication
public class SpringMsProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProductCatalogApplication.class, args);
	}

}
