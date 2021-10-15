package com.example.firstapp.repositories;

import com.example.firstapp.entities.Autor;
import com.example.firstapp.entities.Editorial;
import com.example.firstapp.entities.Libro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {

	@Query("SELECT l FROM Libro l WHERE l.alta = :alta")
	public List<Libro> findByAlta(@Param("alta") Boolean alta);

	public List<Libro> findByAutor(Autor autor);

	public List<Libro> findByEditorial(Editorial editorial);
}