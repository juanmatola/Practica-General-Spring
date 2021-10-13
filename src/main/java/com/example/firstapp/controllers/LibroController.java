package com.example.firstapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.firstapp.entities.Libro;
import com.example.firstapp.interfaces.ErrorHandler;
import com.example.firstapp.services.LibroSerivice;

@Controller
@RequestMapping("/libros")
public class LibroController implements ErrorHandler{
	
	@Autowired
	private LibroSerivice libroSerivice;
	private final String viewPath = "libros/";

	@GetMapping()
	public String index(ModelMap model) {
		
		
		try {
			
			List<Libro> libros = libroSerivice.findAll();
			
			model.addAttribute("libros", libros);
			
		} catch (Exception e) {
			
			this.errorHandle(e, model);
			
		}
		
		return this.viewPath.concat("libros-list");
	}

	@Override
	public String errorHandle(Exception e, ModelMap model) {

		model.addAttribute("err", e.getMessage());

		return this.index(model);
	}
}
