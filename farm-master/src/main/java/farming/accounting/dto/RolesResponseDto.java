package farming.accounting.dto;

import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RolesResponseDto {
	
	public RolesResponseDto(String login2, String roles2) {
		// TODO Auto-generated constructor stub
	}
	private String login;
	private HashSet<String> roles;

}
