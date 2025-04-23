package com.example.demo.dummy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/actuator/health").hasRole("ADMIN")  // Only 'ADMIN' can access health endpoint
//                .anyRequest().authenticated() // Other endpoints require authentication
//                .and()
//                .httpBasic() // Enable basic HTTP authentication
//                .and()
//                .formLogin().permitAll()  // Allow everyone to access the login page
//                .and()
//                .csrf().disable(); // Disable CSRF protection for simplicity in actuator endpoints

        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/actuator/health").permitAll()
                        .requestMatchers("/actuator/custom-endpoint").hasAnyRole("USER", "ADMIN")
                        .anyRequest().permitAll()

        )

//                .httpBasic(a -> {})
//                .formLogin(a -> {})
//                .csrf(a -> {})
        ;

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("USER")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .authorities("USER")
                .build();

        UserDetails admin = User.withUsername("ADMIN")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .authorities("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
