package com.mamdouh.Thymeleafproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Recontroller {
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/signup")
	public String signup() {return "signup";}
	

}