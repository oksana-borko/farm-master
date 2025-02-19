package farming.customer.entity;

import farming.customer.dto.CustomerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private Long customerId;
	
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
    
	public static Customer of(CustomerDto dto) {
		return Customer.builder().customerId(dto.getCustomerId()).
				firstName(dto.getFirstName()).
				lastName(dto.getLastName()).email(dto.getEmail()).
				build();	
	}
	
	public CustomerDto build() {
		return CustomerDto.builder().customerId(customerId).firstName(firstName).
				lastName(lastName).email(email).build();
	}
	
	

}
