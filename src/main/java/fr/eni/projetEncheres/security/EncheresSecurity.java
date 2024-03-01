package fr.eni.projetEncheres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class EncheresSecurity  {

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests				
				.requestMatchers(rs("/", "/index", "/inscription", "/se-connecter", "/css/*").permitAll()
				.requestMatchers("/afficher-profil-utilisateur", "/index-connecte").hasRole("UTILISATEUR")
				.requestMatchers("/admin/**").hasRole("ADMINISTRATEUR")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/se-connecter")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return (PasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	
	
	
	

}
