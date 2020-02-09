package com.gft.casadeeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.casadeeventos.model.Casadeshow;
import com.gft.casadeeventos.repository.Casadeshows;

@Controller
@RequestMapping("/casadeshow")
public class Casadeshowcontroller {
	
	private static final String CASA_VIEW = "Casadeshow";
	
	@Autowired
	private Casadeshows casa;
	
	@RequestMapping
	public ModelAndView casadeshow() {
		List <Casadeshow> todasCasas = casa.findAll();
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		mv.addObject(new Casadeshow());
		mv.addObject("casas", todasCasas);
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String salvar(@Validated Casadeshow casas, Errors errors, RedirectAttributes attributes) {
		if(errors.hasErrors()){
			return "Casadeshow";			
		}
		casa.save(casas);
		attributes.addFlashAttribute("mensagem", "Casa salva com sucesso!!");
		return "redirect:/casadeshow" ;
	}

}
