package pt.sample.ms.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"pt.sample.ms","pt.sample.microservices"})
@SpringBootApplication
public class SpringMsProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProductCatalogApplication.class, args);
	}

}
