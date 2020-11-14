package pt.sample.ms.commons.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Document(collection = "cart")
public class Cart {
    @Id
    String id;

    List<CartItem> items;

}
