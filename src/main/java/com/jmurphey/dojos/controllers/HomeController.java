package com.jmurphey.dojos.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmurphey.dojos.models.Dojo;
import com.jmurphey.dojos.models.Ninja;
import com.jmurphey.dojos.services.ConnectService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	ConnectService service;
	
	
// --- Get Mapping ---
	
	@GetMapping("")
	public String index() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String dojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new.jsp";
	}
	
	@GetMapping("/ninjas")
	public String ninja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("dojos", service.getAllDojos());
		return "ninja.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoNinjas(@PathVariable("id")Long id, Model model) {
		List<Ninja> ninjas = service.getNinjasOfDojo(service.getOneDojo(id));
		Dojo dojo = service.getOneDojo(id);
		
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
	
	
	@GetMapping("/jumpto")
	public String jumpTo(@RequestParam("dojo")Dojo dojo) {
		return String.format("redirect:/dojos/%s", dojo.getId());
	}
	
	
	
// --- Post Mapping --- 
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			service.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", service.getAllDojos());
			return "ninja.jsp";
		} else {
			service.createNinja(ninja);
			return String.format("redirect:/dojos/%s", ninja.getDojo().getId());
		}
	}
	
	
	
}
