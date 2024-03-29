package com.example.employee.configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/token","login","logout").permitAll()
                .antMatchers("/**").fullyAuthenticated()
//                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .defaultSuccessUrl("http://localhost:3000")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("http://localhost:3000/login")
                .and()
                .oauth2ResourceServer().jwt()
                .and()
                .and()
                .cors().and().csrf().disable();
    }

}