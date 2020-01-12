package com.tekleads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class Application {

	@GetMapping("/")
	public String getMsg() {
		String msg = "Welcome OAuth2.0 Security..!!!";
		return msg;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
