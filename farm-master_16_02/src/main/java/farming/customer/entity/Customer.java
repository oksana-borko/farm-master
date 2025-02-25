package farming.customer.entity;

import farming.customer.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String firstName;
	String lastName;
	String email;
	double balance;
	
	public static Customer of(CustomerDto dto) {
		return Customer.builder().id(dto.getCustomerId()).
				firstName(dto.getFirstName()).
				lastName(dto.getLastName()).email(dto.getEmail()).
				build();	
	}

}
