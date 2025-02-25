package farming.farmer.entity;

import java.util.List;
import java.util.Set;

import farming.accounting.entity.UserAccount;
import farming.farmer.dto.AddressDto;
import farming.farmer.dto.FarmerDto;
import farming.products.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "farmers")
public class Farmer  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String firstName;
	String lastName;
	String email;
	String phone;

	//@OneToOne
	Address address;
	
	@ManyToMany(mappedBy = "farmers")
	Set<Product> products;
	
		public static Farmer of(FarmerDto dto) {
		return Farmer.builder().id(dto.getFarmerId()).email(dto.getEmail()).firstName(dto.getFirstName()).
				lastName(dto.getLastName()).phone(dto.getPhone())
				.build();
	}
	
	public Farmer build() {
		return Farmer.builder().email(email).lastName(lastName).firstName(firstName).
				phone(phone).products(products).build();
	}
}
