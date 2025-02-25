package farming.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import farming.accounting.entity.UserAccount;
import farming.accounting.repo.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable())   // Отключаем CSRF (можно включить при необходимости для форм)
            
    	// Настройка авторизации запросов
        .authorizeHttpRequests(authorize -> authorize
            // Публичные эндпоинты доступны всем
        		.requestMatchers("/api/auth/register", "/api/login").permitAll()
            // Админские эндпоинты только для ADMIN
            .requestMatchers("/api/admin/**").hasAuthority("TYPE_ADMIN")
            // Фермерские эндпоинты только для FARMER
            .requestMatchers("/api/farmer/**").hasAuthority("TYPE_FARMER")
            // Клиентские эндпоинты только для CUSTOMER
            .requestMatchers("/api/customer/**").hasAuthority("TYPE_CUSTOMER")
            // Все остальные запросы требуют аутентификации
            .anyRequest().authenticated()
        )
        
        // Настройка формы логина
        .formLogin(form -> form
        		.loginProcessingUrl("/login")
                .defaultSuccessUrl("/api/home", true)
                .permitAll()
        )
        
        // Настройка logout
        .logout(logout -> logout
        		.logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
        )
        
        // Обработка исключений
        .exceptionHandling(exceptions -> exceptions
            .accessDeniedPage("/access-denied")
        );

    return http.build();
}

@Bean
public UserDetailsService userDetailsService() {
	return username -> {
        UserAccount user = userRepository.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        if (user.isRevoked()) {
            throw new UsernameNotFoundException("User account is revoked: " + username);
        }
//	return user; // Возвращаем UserAccount напрямую
//};

        return new org.springframework.security.core.userdetails.User(
            user.getLogin(),
            user.getHash(),
            user.isRevoked() ? java.util.Collections.emptyList() : java.util.Collections.singletonList(
                new org.springframework.security.core.authority.SimpleGrantedAuthority("TYPE_" + user.getUserType().name())
            )
        );
    };
	
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
}