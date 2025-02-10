package telran.entity;

import java.util.List;
import java.util.Set;

import farming.dto.FarmerDto;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "productName")
@Builder
@Entity
@Table(name = "products")
public class Product {
	
	@EmbeddedId
	String productName;
	int quantity;
	Double price;
	String imgUrl;

	@ManyToMany
	 @JoinTable(
		        name = "farmers_products", joinColumns = @JoinColumn(name = "product_id"), 
		        inverseJoinColumns = @JoinColumn(name = "farmer_id"))
	List<Farmer> farmers;

}
