package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/signup", "/login", "/css/**", "/js/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/donor/**").hasAuthority("DONOR")
                .antMatchers("/staff/**").hasAuthority("STAFF")
                .anyRequest().authenticated()
            .and()
            .csrf().disable() // Temporarily disable CSRF for testing
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/redirect", true)
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }
    

    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("PasswordEncoder bean created"); // Debugging
        return new BCryptPasswordEncoder();
    }
    
}
