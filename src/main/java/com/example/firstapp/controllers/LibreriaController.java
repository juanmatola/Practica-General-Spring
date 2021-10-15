package com.example.firstapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.firstapp.entities.Libro;
import com.example.firstapp.services.LibroSerivice;

@Controller
@RequestMapping("/libreria")
public class LibreriaController {
	
	@Autowired
	private LibroSerivice libroSerivice;
	private final String viewPath = "libreria/";

	@GetMapping()
	public String index(ModelMap model) {
		
		List<Libro> libros = libroSerivice.findAvaliables();
		model.addAttribute("libros", libros);
		
		return this.viewPath.concat("index");
	}
}
