package com.example.employee.configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").fullyAuthenticated()
                .antMatchers("http://localhost:3000/login").fullyAuthenticated()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .loginPage("http://localhost:3000/login")
                .defaultSuccessUrl("http://localhost:3000")
                .and()
                .cors().and().csrf().disable();
    }
}