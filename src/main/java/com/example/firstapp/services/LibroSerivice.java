package com.example.firstapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstapp.entities.Libro;
import com.example.firstapp.repositories.LibroRepository;

@Service
public class LibroSerivice {
	
	@Autowired
	private LibroRepository libroRepository;
	
	public List<Libro> findAll() throws Exception{
		
		try {
			
			return libroRepository.findAll();
			
		} catch (Exception e) {
			
			System.err.println(e);
			
			throw new Exception("No se que paso, pero no anda");
			
		}
		
		
	}

	public void changeAltaById(String id) throws Exception{
		
		
		Libro libro = this.findById(id);
		
		libro.setAlta(!libro.getAlta());
		
		libroRepository.save(libro);
		
	}

	private Libro findById(String id) throws Exception{
		
		Optional<Libro> res = libroRepository.findById(id);
		
		if (!res.isEmpty()) {
			return res.get();
		}else {
			throw new Exception("No existe libro con dicho id");
		}
		
	}
	
}