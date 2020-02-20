package com.gft.casadeeventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/historico")
public class Historicocontroller {
	
	private static final String HIST_VIEW = "Historico";
	
	
	@RequestMapping
	public ModelAndView historico() {
		ModelAndView mv = new ModelAndView(HIST_VIEW);
		return mv;
	}
	
	
}
