package com.gft.casadeeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Casadeshow;
import com.gft.casadeeventos.repository.Casadeshows;

@Controller
@RequestMapping("/casadeshow")
public class Casadeshowcontroller {
	
	private static final String CASA_VIEW = "Casadeshow";
	
	@Autowired
	private Casadeshows casas;
	
	@RequestMapping
	public ModelAndView casadeshow() {
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar(Casadeshow casa) {
		List <Casadeshow> todasCasas = casas.findAll();
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		casas.save(casa);
		mv.addObject("casas", todasCasas);
		return mv;
	}
	
}
