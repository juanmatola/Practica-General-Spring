package com.example.firstapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.firstapp.entities.Autor;
import com.example.firstapp.servicios.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired
	private AutorService autorService;
	
	@GetMapping()
	public String index(ModelMap modeloDeIndex) {
		
		//prueba de envio de datos hacia una vista
		
		String nombre = "Juan";
		
		ArrayList<String> nombres = new ArrayList<String>();
		
		nombres.add(nombre);
		nombres.add("Hola");
		nombres.add("Como");
		nombres.add("Va");
		nombres.add("AAAAAA");
		nombres.add("BBBB");
		
		modeloDeIndex.addAttribute("nombres", nombres);
		
		return "index";
	}
	
	@GetMapping("/autores")
	public String autores(ModelMap modeloDeAutores) {
		
		List<Autor> misAutores = autorService.findAll();
		
		modeloDeAutores.addAttribute("autores", misAutores);
		
		return "autores-list";
	}
	
	
	@GetMapping("/newautor")
	
	public String newAutor(){
		return "create-autor";
	}
	
	@PostMapping("/newautor/create")
	public String createAutor(@RequestParam("nombreAutor") String nombreAutor){
		
		//cerar el autor con el nombre recibido y persistir
		
		return "create-autor";
	}
	
	
}
