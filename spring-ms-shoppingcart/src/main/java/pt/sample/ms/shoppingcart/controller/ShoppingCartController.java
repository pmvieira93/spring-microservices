package pt.sample.ms.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import pt.sample.ms.commons.entity.Cart;
import pt.sample.ms.commons.entity.CartItem;
import pt.sample.ms.commons.entity.Product;
import pt.sample.ms.shoppingcart.services.ShoppingCartService;

@RestController
@RefreshScope
public class ShoppingCartController {

	Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ShoppingCartService shoppingCartService;

	@PostMapping("/cart/{cartId}/item")
	public Cart addItem(@PathVariable String cartId, @RequestBody CartItem item) {
		logger.info("add item - process started");
		if (cartId != null && item != null && item.getProductId() != null) {
			logger.info("add item - calling product catalog service");
			
			// get product details
			Product itemProduct = restTemplate.getForObject("http://localhost:8081/product/" + item.getProductId(),
					Product.class);
			if (itemProduct != null && itemProduct.getId() != null) {
				// adding total item price in the shopping cart item
				item.setTotalItemPrice(itemProduct.getUnitPrice() * item.getQuantity());
				logger.info("add item - process completed successfully");
				
				return shoppingCartService.addItem(cartId, item);
			}
			logger.warn("add item - item product not found");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item product not found");
		}
		logger.error("add item - cart or item missing");
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cart or item missing");
	}

	@PostMapping("/zuul/cart/{cartId}/item")
	public Cart addItemByZuul(@PathVariable String cartId, @RequestBody CartItem item) {
		if (cartId != null && item != null && item.getProductId() != null) {

			String productCatalogUrl = "http://localhost:8762/ms-product-catalog/product/" + item.getProductId();

			// get product details
			Product itemProduct = restTemplate.getForObject(productCatalogUrl, Product.class);
			if (itemProduct != null && itemProduct.getId() != null) {
				// adding total item price in the shopping cart item
				item.setTotalItemPrice(itemProduct.getUnitPrice() * item.getQuantity());
				return shoppingCartService.addItem(cartId, item);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item product not found");
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cart or item missing");
	}

}
