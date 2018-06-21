package com.wu.oauth2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * @author alex
 */
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
public class Oauth2ClientApplication {


	@RequestMapping("/")
	public String home(Principal user) {
		return "Hello " + user.getName();
	}


	public static void main(String[] args) {
		SpringApplication.run(Oauth2ClientApplication.class, args);
	}
}
