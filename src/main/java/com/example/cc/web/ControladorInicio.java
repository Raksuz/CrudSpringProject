package com.example.cc.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cc.domain.Persona;
import com.example.cc.servicio.IPersonaService;

@Controller
public class ControladorInicio {
	
	@Autowired
	private IPersonaService personaService;


	@GetMapping("/")
	private String Saludo(Model m) {
		var personas = personaService.listarP();
		m.addAttribute("personas", personas);
		return "index";
	}
	
	@GetMapping("/agregar")
	private String agregar(Persona persona) {
		return "modificar";
	}
	
	@PostMapping("/guardar")
	private String guardar(@Valid Persona persona, Errors errores) {
		if(errores.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	private String editar(Persona persona, Model m) {
		persona = personaService.buscarP(persona);
		m.addAttribute("persona", persona);
		return "modificar";
	}
	
	@GetMapping("/eliminar")
	private String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";
	}
}
