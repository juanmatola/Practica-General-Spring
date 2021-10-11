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
		
		String res = "redirect:/autores?insertResult=";
		
		try {
			
			autorService.save(name);
			
			res = res.concat("true");
			
		} catch (Exception e) {
			
			System.err.print("Error al insertar nuevo autor " + e.toString());
		
			res = res.concat("false");
			
		}

		return res;
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") String id) {
		
		autorService.removeById(id);
		
		return "redirect:/autores";
	}
	
	@GetMapping("/changestatus/{id}")
	public String changeStatus(@PathVariable("id") String id) {
		
		autorService.changeStatus(id);
		
		return "redirect:/autores";
	}
	
	@GetMapping("/changename/{id}")
	public String changeName(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("id",id);
		
		return "modifyAutor.html";
		
	}
	
	@PostMapping("/changename")
	public String changing(@RequestParam("id") String id, @RequestParam("name") String name){
		try {
			autorService.changeNamebyId(id, name);
		} catch (Exception e) {
			System.err.println("ERROR AL MODIFICAR EL NOMBRE, DESCRIPCION: "+ e);
		}
		
		return"redirect:/autores";
	}
	

}
