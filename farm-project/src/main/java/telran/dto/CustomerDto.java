package telran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerDto {

	Long customerId;
	String login;
	String password;
	String firstName;
	String lastName;
	String email;
	AddressDto address;
	int balance;
}
