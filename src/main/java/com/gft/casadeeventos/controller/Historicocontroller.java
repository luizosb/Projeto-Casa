package com.gft.casadeeventos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Ingresso;
import com.gft.casadeeventos.repository.Ingressos;

@Controller
@RequestMapping("/historico")
public class Historicocontroller {
	
	private static final String HIST_VIEW = "Historico";
	
	@Autowired
	private Ingressos ingress;
	
	@RequestMapping
	public ModelAndView historico() {
		List<Ingresso> ingressos = ingress.findAll();
		ModelAndView mv = new ModelAndView(HIST_VIEW);
		mv.addObject(new Ingresso());
		mv.addObject("ingressos", ingressos);
		return mv;
		
	}
	
	
}
