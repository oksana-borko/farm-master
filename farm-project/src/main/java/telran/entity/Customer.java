package telran.entity;

import java.time.LocalDateTime;
import java.util.Set;

import farming.dto.AddressDto;
import farming.dto.CustomerDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
	   private Long customerId;
	   private String firstName;
	   private String lastName;
	   private String email;
	   private String username;
	   private String hash;
	   private Set<String> roles;
	   private LocalDateTime passwordExpiration;
	   private boolean revoked;
	   private LocalDateTime activationDate;
	   private LocalDateTime registrationDate;
	   private LocalDateTime lastLoginDate;
	
	@Embedded
	AddressDto address;
	
	double balance;
	
	public static Customer of(CustomerDto dto) {
		return Customer.builder().customerId(dto.getCustomerId()).
				firstName(dto.getFirstName()).
				lastName(dto.getLastName()).address(dto.getAddress()).email(dto.getEmail()).
				build();	
	}
	
	public CustomerDto build() {
		return CustomerDto.builder().customerId(customerId).firstName(firstName).
				lastName(lastName).email(email).address(address).build();
	}

}
