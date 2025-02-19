package farming.farmer.entity;

import java.util.Set;

import farming.farmer.dto.AddressDto;
import farming.farmer.dto.FarmerDto;
import farming.products.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "farmers")
public class Farmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long farmerId;
	
	@Column(nullable=false, length=50)
	private String firstName;
	
	@Column(nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, length=150, unique=true)
	private String email;
	
	@Column(nullable=false)
	private double balance;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String phone;
	
	@Embedded
	private AddressDto address;
	
	
	@ManyToMany(mappedBy = "farmers")
	@JoinTable(name = "farmer_products", joinColumns = @JoinColumn(name = "farmer_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	Set<Product> products;
	
		public static Farmer of(FarmerDto dto) {
		return Farmer.builder().email(dto.getEmail()).firstName(dto.getFirstName()).
				lastName(dto.getLastName()).phone(dto.getPhone()).address(dto.getAddress())
				.build();
	}
	
	public FarmerDto build() {
		return FarmerDto.builder().email(email).lastName(lastName).firstName(firstName).
				phone(phone).address(address)
				.build();
	}

}
