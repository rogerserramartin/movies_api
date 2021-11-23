package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.security.ApplicationUserRole.*;

@Configuration //this indicates that this class is a configuration one for SpringBoot
@EnableWebSecurity // It allows Spring to find (it's a @Configuration and, therefore, @Component ) and automatically apply the class to the global WebSecurity .
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired //with this we don't need to code application = new ApplicationSec...()
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) { //this passwordencoder will be the same as the one in passwordconfig.java, which is BCrypt
        this.passwordEncoder = passwordEncoder;
    }
    // press control + o to override

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll() //whitelisting to prevent asking credentials
                .antMatchers("/api/**").hasRole(CUSTOMER.name()) //only customers will see the movies
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(); //basic authentication
        //localhost:8080/api/v1/movies/{id} to see the popup
        //Basic dXNlcjpiZmU2NWVhOC1lZWJiLTQ1OGYtYmUyYS1lYWUxMjNkN2NhOTg=   Example of Basic64 Encryption
    }

    //
    @Override
    @Bean //this will be instantiated for us
    protected UserDetailsService userDetailsService() { //this is how we retrieve our users from our database
        UserDetails pepeUser = User.builder()
                .username("pepe")
                .password(passwordEncoder.encode("123")) // Encoded password does not look like BCrypt -> this is what happens without passwordEncoder
                .roles(CUSTOMER.name()) //ROLE_CUSTOMER
                .build();

        UserDetails milagrosUser = User.builder()
                .username("milagros")
                .password(passwordEncoder.encode("1234"))
                .roles(ADMIN.name()) //ROLE_ADMIN
                .build();


        return new InMemoryUserDetailsManager(
                pepeUser,
                milagrosUser
        );
    }
}
