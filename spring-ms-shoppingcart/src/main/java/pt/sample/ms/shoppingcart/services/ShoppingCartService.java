package pt.sample.ms.shoppingcart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;

import pt.sample.ms.commons.entity.Cart;
import pt.sample.ms.commons.entity.CartItem;

@Service
public class ShoppingCartService {

	@Autowired
    MongoTemplate mongoTemplate;

    public Cart addItem(String cartId, CartItem item){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(cartId));
        Update update = new Update();
        update.addToSet("items", item);
        UpdateResult result = mongoTemplate.upsert(query, update, Cart.class);
        return this.getCart(cartId == null ? result.getUpsertedId().toString() : cartId);        
    }

    public Cart getCart(String cartId) {
        return mongoTemplate.findById(cartId, Cart.class);
    }
}
