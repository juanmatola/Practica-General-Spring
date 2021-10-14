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

import com.example.firstapp.entities.Libro;
import com.example.firstapp.interfaces.ErrorHandler;
import com.example.firstapp.services.AutorService;
import com.example.firstapp.services.EditorialService;
import com.example.firstapp.services.LibroSerivice;

@Controller
@RequestMapping("/libros")
public class LibroController implements ErrorHandler {

	@Autowired
	private LibroSerivice libroSerivice;
	@Autowired
	private AutorService autorService;
	@Autowired
	private EditorialService editorialService;

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

	@GetMapping("/create")
	public String createForm(ModelMap model) {

		model.addAttribute("autores", autorService.findAll());
		model.addAttribute("editoriales", editorialService.findAll());

		return this.viewPath.concat("create-libro");
	}

	@PostMapping("/create")
	public String create(ModelMap model,
			@RequestParam("titulo") String titulo, @RequestParam("isbn") String isbn,
			@RequestParam("ejemplares") String ejemplares, @RequestParam("anio") String anio,
			@RequestParam("autor") String autorID, @RequestParam("editorial") String editorialID) {
		
		try {
			
			libroSerivice.save(isbn, titulo, ejemplares, anio, autorID, editorialID);
			
		} catch (Exception e) {
			return this.errorHandle(e, model);
		}

		return "redirect:/".concat(viewPath);
	}

	@GetMapping("/update/{id}")
	public String updateForm(ModelMap model, @PathVariable("id") String id) {

		model.addAttribute("autores", autorService.findAll());
		model.addAttribute("editoriales", editorialService.findAll());

		return this.viewPath.concat("update-libro");
	}

	@GetMapping("/update/alta/{id}")
	public String changeAlta(ModelMap model, @PathVariable("id") String id) {

		try {

			libroSerivice.changeAltaById(id);

			return "redirect:/libros";

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
