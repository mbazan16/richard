package es.tiendazara.web.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails usuario = User.withUsername("usuario").password(passwordEncoder().encode("usuario")).roles("USER")
				.build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(usuario, admin);
	}


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests(authorize -> authorize
                .requestMatchers(HttpMethod.GET, "/css/**", "/js/**", "/img/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions().sameOrigin())
            .formLogin(form -> form
                .loginPage("/login")
                .failureUrl("/loginError")
                .successForwardUrl("/user")
                .permitAll()
            )
            .exceptionHandling().accessDeniedPage("/accessDenied")
            .and()
            .logout(logout -> logout.permitAll());

        return http.build();
    }
     
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
     
   
 }

