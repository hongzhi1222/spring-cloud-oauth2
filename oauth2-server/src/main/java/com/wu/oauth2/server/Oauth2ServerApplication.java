package com.wu.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alex
 *
 * 1	All requests are protected by default
 * 2	The home page and login endpoints are explicitly excluded
 * 3	All other endpoints require an authenticated user
 * 4	Unauthenticated users are re-directed to the home page
 */
@SpringBootApplication
@RestController
@EnableOAuth2Client
@EnableAuthorizationServer
public class Oauth2ServerApplication extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")                                       //(1)
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**").permitAll() //(2)
                .anyRequest().authenticated()                            //(3)
                .and().exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")); //(4)
    }

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApplication.class, args);
    }
}
