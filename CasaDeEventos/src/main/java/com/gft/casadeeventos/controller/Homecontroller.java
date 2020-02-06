package com.gft.casadeeventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class Homecontroller {
	
	private static final String HOME_VIEW = "Home";
	
	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView(HOME_VIEW);
		return mv;
	}
		
	
	
}
