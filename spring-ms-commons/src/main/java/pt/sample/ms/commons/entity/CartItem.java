package pt.sample.ms.commons.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CartItem {
	
	String productId;
    int quantity;
    double totalItemPrice;
    
}
