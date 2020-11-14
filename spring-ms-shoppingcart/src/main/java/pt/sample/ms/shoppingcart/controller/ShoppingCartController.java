package pt.sample.ms.shoppingcart.controller;

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

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ShoppingCartService shoppingCartService;

	@PostMapping("/cart/{cartId}/item")
	public Cart addItem(@PathVariable String cartId, @RequestBody CartItem item) {
		if (cartId != null && item != null && item.getProductId() != null) {
			// get product details
			Product itemProduct = restTemplate.getForObject("http://localhost:8081/product/" + item.getProductId(),
					Product.class);
			if (itemProduct != null && itemProduct.getId() != null) {
				// adding total item price in the shopping cart item
				item.setTotalItemPrice(itemProduct.getUnitPrice() * item.getQuantity());
				return shoppingCartService.addItem(cartId, item);
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item product not found");
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cart or item missing");
	}

	@PostMapping("/zuul/cart/{cartId}/item")
	public Cart addItemByZuul(@PathVariable String cartId, @RequestBody CartItem item) {
		if (cartId != null && item != null && item.getProductId() != null) {

			String productCatalogUrl = "http://localhost:8762/product_catalog/product/" + item.getProductId();

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
