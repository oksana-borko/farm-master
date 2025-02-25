package farming.products.entity;

import java.util.List;

import farming.farmer.entity.Farmer;
import farming.products.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	public String productName;
	public int quantity;
	public Double price;
	public String imgUrl;

	@ManyToMany
	 @JoinTable(
		        name = "farmers_products", joinColumns = @JoinColumn(name = "id"),
		        inverseJoinColumns = @JoinColumn(name = "farmer_id"))
	List<Farmer> farmers;
	
	public static Product of(ProductDto dto) {
		return Product.builder().id(dto.getProductId()).productName(dto.getProductName()).
				quantity(dto.getQuantity()).price(dto.getPrice()).imgUrl(dto.getImgUrl()).build();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
