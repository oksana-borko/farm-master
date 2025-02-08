package telran.entity;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Set;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class CustomerAccount {
    @Id
    private String username;
    
    private String firstName;
    private String lastName;
    private String hash;
    private Set<String> roles;
    private String email;
    private LocalDateTime passwordExpiration;
    private boolean revoked;
    private LocalDateTime activationDate;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;
}