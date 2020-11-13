package pt.sample.ms.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.sample.ms.commons.entity.Product;

@SpringBootApplication
public class SpringMsShoppingcartApplication {

	public static void main(String[] args) {
		Product p = new Product();
		p.setDesc("hello");
		SpringApplication.run(SpringMsShoppingcartApplication.class, args);
	}

}
