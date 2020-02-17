package com.gft.casadeeventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.Eventos;

@Controller
@RequestMapping("/home/comprar/")
public class Comprarcontroller {
	
private static final String COMPRAR_VIEW = "HomeComprar";
	
	@Autowired
	private Eventos event;
	
	@RequestMapping(value ="{codigo}", method= RequestMethod.GET)
	public ModelAndView tela(@PathVariable Long codigo) {
		Evento todosEventos = event.getOne(codigo);
		ModelAndView mv = new ModelAndView(COMPRAR_VIEW);
		mv.addObject("eventos", todosEventos);
		mv.addObject(new Evento());
		return mv;
	}

	@RequestMapping(value="{codigo}", method=RequestMethod.POST)
	public ModelAndView comprar(@PathVariable("codigo") Long codigo, int qtdIngresso) {
		Evento todosEventos = event.findById(codigo).get();
		ModelAndView mv = new ModelAndView(COMPRAR_VIEW);
		todosEventos.setqtdIngresso(qtdIngresso);
		event.save(todosEventos);
		todosEventos.setCapacidade(todosEventos.getCapacidade()-todosEventos.getqtdIngresso());
		mv.addObject(new Evento());
		event.save(todosEventos);
		return mv;
	}
}
