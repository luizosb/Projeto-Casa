package com.gft.casadeeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.Eventos;

@Controller
@RequestMapping("/evento")
public class Eventocontroller {
	
	private static final String EVENTO_VIEW = "Evento";
	@Autowired
	private Eventos event;
	
	@RequestMapping
	public ModelAndView evento() {
		ModelAndView mv = new ModelAndView("Evento");
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar(Evento evento) {
		List <Evento> todosEventos = event.findAll();
		ModelAndView mv = new ModelAndView(EVENTO_VIEW);
		event.save(evento);
		mv.addObject("eventos", todosEventos);
		return mv;
	}

}
