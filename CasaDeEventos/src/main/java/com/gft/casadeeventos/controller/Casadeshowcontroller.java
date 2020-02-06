package com.gft.casadeeventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/casadeshow")
public class Casadeshowcontroller {
	
	@RequestMapping
	public ModelAndView casadeshow() {
		ModelAndView mv = new ModelAndView("Casadeshow");
		return mv;
	}
	
	
	
	
	
}
