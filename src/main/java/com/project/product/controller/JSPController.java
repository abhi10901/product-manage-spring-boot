package com.project.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSPController {

	@RequestMapping(value = "/jsptest", method = RequestMethod.GET)
	public String test(ModelAndView modelAndView) {
		return "jsp-spring-boot";
	}
}
