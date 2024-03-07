package fr.eni.projetEnchereHugo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    	
        return httpSecurity
        		
        		.authorizeHttpRequests(
    					auth->{
    						auth.requestMatchers("/mon-compte/**").authenticated();
    						auth.anyRequest().permitAll();
    					})
    				.formLogin( login->{
    					login.loginPage("/login");
    					login.failureUrl("/login-error");
    					login.defaultSuccessUrl("/mon-compte");
    				})
    				.logout( logout->{
    					logout.logoutUrl("/logout");
    					logout.logoutSuccessUrl("/");
    				})
    				.build()
    				;
    }

    @Bean
    InMemoryUserDetailsManager userDetailsService() {

    	UserDetails user = User.withUsername("user")
                .password("{noop}password") 
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("{noop}password")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
