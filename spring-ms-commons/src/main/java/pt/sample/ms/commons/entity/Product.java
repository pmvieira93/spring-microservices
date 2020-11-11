package pt.sample.ms.commons.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Document(collection = "product")
public class Product {
	
    @Id
    private String id;
    private String title;
    private String desc;
    private String imagePath;
    private double unitPrice;
	
    @Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", desc=" + desc + ", imagePath=" + imagePath + ", unitPrice="
				+ unitPrice + "]";
	}

}
