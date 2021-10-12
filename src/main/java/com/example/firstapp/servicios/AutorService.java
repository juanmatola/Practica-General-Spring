package com.example.firstapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstapp.entities.Autor;
import com.example.firstapp.repositories.AutorRepository;

@Service
public class AutorService {
	
	
	@Autowired
	private AutorRepository repoAutor;
	

	public Autor createAutor(String name) {
		return new Autor(name);
	}
	
	public List<Autor> findAll(){
		
		return repoAutor.findAll();

	}

	public void removeById(String id) throws Exception {
		
		try {
			repoAutor.deleteById(id);			
		} catch (Exception e) {
			throw new Exception("Error al eliminar el autor, verifique que no tiene Libros registrados en la aplicación");
		}
		
	}
	
	public void chageAltaById(String id) throws Exception {
		Autor autor = this.findById(id);
		
		autor.setAlta(!autor.getAlta());
		
		repoAutor.save(autor);
	}
	
	public Autor findById(String id) throws Exception {
		
		Optional<Autor> res = repoAutor.findById(id);
		
		if(!res.isEmpty()) {
			return res.get();
		}else {
			throw new Exception("No existe autor con dicho id");
		}
		
	}
	
	public Autor findByName(String name) throws Exception {
		
		Optional<Autor> res = repoAutor.findByName(name);
		
		if(!res.isEmpty()) {
			return res.get();
		}else {
			throw new Exception("No existe autor con dicho nombre");
		}
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Autor save(String name) throws Exception {
		
		return repoAutor.save(this.createAutor(name));
		
	}
	
}