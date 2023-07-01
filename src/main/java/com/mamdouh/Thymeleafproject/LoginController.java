package com.mamdouh.Thymeleafproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login.html")
public class LoginController {
	@GetMapping("/login.html")
	public String login() {
		return "login";
	}
}
