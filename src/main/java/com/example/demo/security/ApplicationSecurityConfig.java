package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //this indicates that this class is a configuration one for SpringBoot
@EnableWebSecurity // It allows Spring to find (it's a @Configuration and, therefore, @Component ) and automatically apply the class to the global WebSecurity .
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    // press control + o to override

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll() //whitelisting to prevent asking credentials
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(); //basic authentication
        //localhost:8080/api/v1/movies/{id} to see the popup
        //Basic dXNlcjpiZmU2NWVhOC1lZWJiLTQ1OGYtYmUyYS1lYWUxMjNkN2NhOTg=   Example of Basic64 Encryption
    }
}
