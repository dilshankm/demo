package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@PostMapping(path = "/hello")
	public String hello() {
		return "hello";
	}

}
