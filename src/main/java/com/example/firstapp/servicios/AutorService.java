package com.example.firstapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstapp.entities.Autor;
import com.example.firstapp.repositories.AutorRepository;

@Service
public class AutorService {
	
	
	@Autowired
	private AutorRepository repoAutor;
	

	public List<Autor> findAll(){
		return repoAutor.findAll();
	}
}