package com.example.firstapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.firstapp.entities.Editorial;
import com.example.firstapp.services.EditorialService;

@Controller
@RequestMapping("/editoriales")
public class EditorialController {

	@Autowired
	private EditorialService editorialService;
	private final String viewPath = "editoriales/";

	@GetMapping
	public String index(ModelMap model) {
		
		List<Editorial> editoriales = editorialService.findAll();
		
		model.addAttribute("editoriales", editoriales);
		
		return this.viewPath.concat("editoriales-list");
		
	}
	
}
