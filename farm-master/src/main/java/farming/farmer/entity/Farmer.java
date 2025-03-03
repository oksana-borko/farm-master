package farming.farmer.entity;

import java.util.List;
import java.util.Set;

import farming.accounting.entity.UserAccount;
import farming.farmer.dto.AddressDto;
import farming.farmer.dto.FarmerDto;
import farming.products.entity.Product;
import farming.products.entity.SurpriseBag;
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
	Long farmerId;

//	String firstName;
//	String lastName;
	String email;
	
	@OneToOne
    @JoinColumn(name = "login", referencedColumnName = "login")
    UserAccount userAccount;
	
	String phone;

	@Embedded
	Address address;
	
	@OneToMany(mappedBy = "farmer")
	Set<Product> products;
	
	@OneToMany(mappedBy = "farmer")
	List<SurpriseBag> surpriseBags;
	
	Double balance;
	
		public static Farmer of(FarmerDto dto) {
			return Farmer.builder()
	                .farmerId(dto.getFarmerId()).phone(dto.getPhone())
	                .address(dto.getAddress() != null ? new Address(dto.getAddress().getCountry(), dto.getAddress().getCity(), 
	                		dto.getAddress().getStreet()) : null)
	                .balance(dto.getBalance()).build();
	}
	

		public FarmerDto build() {
	        return FarmerDto.builder()
	                .farmerId(farmerId)
	                .login(userAccount != null ? userAccount.getLogin() : null)
	                .phone(phone)
	                .address(address != null ? new AddressDto(address.getCountry(), address.getCity(), address.getStreet()) : null)
	                .balance(balance)
	                .build();
	    }


		
}
