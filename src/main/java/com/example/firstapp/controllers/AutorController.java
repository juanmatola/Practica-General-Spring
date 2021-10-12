package com.example.firstapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.firstapp.entities.Autor;
import com.example.firstapp.servicios.AutorService;


@Controller
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping()
	public String index(ModelMap modeloDeAutores) {
		
		List<Autor> misAutores = autorService.findAll();
		
		modeloDeAutores.addAttribute("autores", misAutores);
		
		return "autores-list";
	}
	
	@GetMapping("/create")
	public String create() {
		
		return "create-autor";
		
	}
	
	@PostMapping("/create")
	public String runCreate(ModelMap model, @RequestParam("name") String name) {
		
		try {
			
			autorService.save(name);
			
			return "redirect:/autores";
			
		} catch (Exception e) {
		
			model.addAttribute("err", e.getMessage());
			
			return this.index(model);
		}

	}
	
	@GetMapping("/update/alta/{id}")
	public String updateAlta(ModelMap model, @PathVariable("id") String id) {
		
		try {			
			
			autorService.chageAltaById(id);
			
			return "redirect:/autores";
			
		} catch (Exception e) {
			
			model.addAttribute("err", e.getMessage());
			
			return this.index(model);
		}
		
	}

	@GetMapping("/remove/{id}")
	public String remove(ModelMap model, @PathVariable("id") String id) {
		
		try {
			
			autorService.removeById(id);
			
			return "redirect:/autores";
			
		} catch (Exception e) {
			
			model.addAttribute("err", e.getMessage());
			
			return this.index(model);
		}
		
	}
	
}