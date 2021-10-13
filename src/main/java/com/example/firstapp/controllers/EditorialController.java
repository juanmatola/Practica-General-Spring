package com.example.firstapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.firstapp.entities.Editorial;
import com.example.firstapp.interfaces.ErrorHandler;
import com.example.firstapp.services.EditorialService;

@Controller
@RequestMapping("/editoriales")
public class EditorialController implements ErrorHandler {

	@Autowired
	private EditorialService editorialService;
	private final String viewPath = "editoriales/";

	@GetMapping
	public String index(ModelMap model) {

		List<Editorial> editoriales = editorialService.findAll();

		model.addAttribute("editoriales", editoriales);

		return this.viewPath.concat("editoriales-list");

	}

	@GetMapping("/create")
	public String create() {

		return this.viewPath.concat("create-editorial");

	}

	@PostMapping("/create")
	public String runCreate(ModelMap model, @RequestParam("name") String name) {

		try {

			editorialService.save(name);

			return "redirect:/editoriales";

		} catch (Exception e) {

			return this.errorHandle(e, model);

		}

	}

	@Override
	public String errorHandle(Exception e, ModelMap model) {

		model.addAttribute("err", e.getMessage());

		return this.index(model);
	}
}
