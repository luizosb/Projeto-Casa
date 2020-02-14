package com.gft.casadeeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.casadeeventos.model.Casadeshow;
import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.Casadeshows;
import com.gft.casadeeventos.repository.Eventos;

@Controller
@RequestMapping("/evento")
public class Eventocontroller {
	
	private static final String EVENTO_VIEW = "Evento";
	
	@Autowired
	private Eventos event;
	
	@Autowired
	private Casadeshows casa;
	
	@RequestMapping
	public ModelAndView evento() {
		List <Evento> todosEventos = event.findAll();
		ModelAndView mv = new ModelAndView(EVENTO_VIEW);
		mv.addObject(new Evento());
		mv.addObject("eventos", todosEventos);
		List <Casadeshow> todasCasas = casa.findAll();
		mv.addObject("casas", todasCasas);
		return mv;
	}
	
	@RequestMapping("/editar/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Evento eventoedit) {
		ModelAndView mv = new ModelAndView(EVENTO_VIEW);
		mv.addObject(eventoedit);
		List <Casadeshow> todasCasas = casa.findAll();
		mv.addObject("casas", todasCasas);
		return mv;
	}
	
	@RequestMapping(value ="{codigo}", method = RequestMethod.GET)
	public String excluir(@PathVariable Long codigo){
		event.deleteById(codigo);
		return "redirect:/evento";
	}	
		
	@RequestMapping(method= RequestMethod.POST)
	public String salvar(@Validated Evento evento, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()){
			return "/evento";			
		}
		event.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento salvo com sucesso!!");
		return "redirect:/evento";
	}
	
}
