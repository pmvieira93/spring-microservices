package pt.sample.ms.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@ComponentScan({"pt.sample.ms"})
@SpringBootApplication
public class SpringMsShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsShoppingCartApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
