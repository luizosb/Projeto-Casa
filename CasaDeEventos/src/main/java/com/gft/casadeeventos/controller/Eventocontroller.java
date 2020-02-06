package com.gft.casadeeventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/evento")
public class Eventocontroller {
	
	@RequestMapping
	public ModelAndView evento() {
		ModelAndView mv = new ModelAndView("Evento");
		return mv;
	}

}
