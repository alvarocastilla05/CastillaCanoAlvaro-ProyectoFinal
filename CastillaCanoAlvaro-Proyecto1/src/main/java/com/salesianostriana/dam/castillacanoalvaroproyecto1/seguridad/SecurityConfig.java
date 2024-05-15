package com.salesianostriana.dam.castillacanoalvaroproyecto1.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder
			.authenticationProvider(daoAuthenticationProvider())
			.build();
		
	}

    
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	RequestCache requestCache = new NullRequestCache();
    	
    	http.authorizeHttpRequests(
				(authz) -> authz.requestMatchers("/css/**", "/js/**", "/h2-console/**", "/img/**","/", "/escuela", 
						"/ubicacion", "/director", "/cartas/eventos/**" ).permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated()).requestCache(cache -> cache.requestCache(requestCache))
			.formLogin((loginz) -> loginz
					.loginPage("/login")
					.successHandler(authenticationSuccessHandler)
					.permitAll())
			.logout((logoutz) -> logoutz
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					.permitAll());
    	
    
		
		// Añadimos esto para poder seguir accediendo a la consola de H2
		// con Spring Security habilitado.
    	http.csrf(csrfz -> csrfz.disable());
    	http.headers(headersz -> headersz
    			.frameOptions(frameOptionsz -> frameOptionsz.disable()));
		
		return http.build();
	}

}