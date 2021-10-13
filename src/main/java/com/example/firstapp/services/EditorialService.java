package com.example.firstapp.services;

import java.util.List;
import java.util.Optional;

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

	public void chageAltaById(String id) throws Exception {

		Editorial editorial = this.findById(id);

		editorial.setAlta(!editorial.getAlta());

		try {

			editorialRepository.save(editorial);

		} catch (Exception e) {

			System.err.println(e);

			throw new Exception("Hubo algun error para guardar el cambio realizado");

		}

	}

	public void update(String id, String name) throws Exception {

		Editorial editorial = this.findById(id);

		editorial.setNombre(name);

		try {

			editorialRepository.save(editorial);

		} catch (Exception e) {

			System.err.println(e);

			throw new Exception("Hubo algun error para guardar el cambio realizado");

		}

	}

	public void removeById(String id) throws Exception {

		try {

			editorialRepository.deleteById(id);

		} catch (Exception e) {

			throw new Exception(
					"Error al eliminar la editorial, verifique que no tiene Libros registrados en la aplicación");

		}

	}

	public Editorial findById(String id) throws Exception {

		Optional<Editorial> res = editorialRepository.findById(id);

		if (!res.isEmpty()) {
			return res.get();
		} else {
			throw new Exception("No existe editorial con dicho id");
		}

	}

}
