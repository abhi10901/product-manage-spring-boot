package com.project.product.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greeting from Abhishek Bhandari...!";
	}
	
	@RequestMapping("/jsontest")
	public @ResponseBody Map<String, String> callSomething() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("url", "http://www.myweb.com");
		
		return map;
	}
}
