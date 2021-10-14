package com.example.firstapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstapp.entities.Autor;
import com.example.firstapp.entities.Editorial;
import com.example.firstapp.entities.Libro;
import com.example.firstapp.repositories.LibroRepository;

@Service
public class LibroSerivice {

	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorService autorService;
	@Autowired
	private EditorialService editorialService;

	public void save(String isbn, String titulo, String ejemplares,
			String anio, String autorID, String editorialID)  throws Exception{
		
		Long isbnLong = Long.parseLong(isbn);
		Integer ejemplaresInt = Integer.parseInt(ejemplares);
		Integer anioInt = Integer.parseInt(anio);
		
		try {
			
			Autor autor = autorService.findById(autorID);
			Editorial editorial = editorialService.findById(editorialID);
			Libro libro = new Libro(isbnLong, titulo, anioInt, ejemplaresInt, autor, editorial);
			
			libroRepository.save(libro);
			
		} catch (Exception e) {
			throw new Exception("Error en la creación del libro");
		}
		
	}

	public List<Libro> findAll() throws Exception {

		try {

			return libroRepository.findAll();

		} catch (Exception e) {

			System.err.println(e);

			throw new Exception("No se que paso, pero no anda");

		}

	}

	public void changeAltaById(String id) throws Exception {

		Libro libro = this.findById(id);

		libro.setAlta(!libro.getAlta());

		libroRepository.save(libro);

	}

	private Libro findById(String id) throws Exception {

		Optional<Libro> res = libroRepository.findById(id);

		if (!res.isEmpty()) {
			return res.get();
		} else {
			throw new Exception("No existe libro con dicho id");
		}

	}

}