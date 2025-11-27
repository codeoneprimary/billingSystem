package com.billing.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String index() {
		System.out.println("home");
		return "home";
	}

	@GetMapping("/home")
	public String home() {
		System.out.println("home");
		return "home";
	}

	@GetMapping("/history")
	public String history() {
		return "about";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/gallery")
	public String gallery() {
		return "gallery";
	}

}
