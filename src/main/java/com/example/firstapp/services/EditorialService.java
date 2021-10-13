package com.example.firstapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstapp.entities.Editorial;
import com.example.firstapp.repositories.EditorialRepository;

@Service
public class EditorialService {
	@Autowired
	private EditorialRepository editorialRepository;

	public Editorial createEditorial(String name) {
		return new Editorial(name);
	}

	public List<Editorial> findAll() {

		return editorialRepository.findAll();

	}

	public void save(String name) throws Exception {

		editorialRepository.save(this.createEditorial(name));

	}

}
