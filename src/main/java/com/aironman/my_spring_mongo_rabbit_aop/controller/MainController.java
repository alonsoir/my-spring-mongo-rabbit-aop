package com.aironman.my_spring_mongo_rabbit_aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping
	public String getMainPage() {
		return "redirect:/event";
	}
}
