package com.smartattendance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/login","/resources/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/dashboard", true)
            .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login?out=true");
    }
}
