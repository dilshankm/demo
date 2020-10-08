package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@PostMapping(path = "/hello/{hello}")
	public String hello(@PathVariable String hello) {
		System.out.println(hello);
		return "hello " + hello;
	}

}
