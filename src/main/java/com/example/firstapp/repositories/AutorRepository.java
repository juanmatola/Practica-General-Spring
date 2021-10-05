package com.example.firstapp.repositories;

import com.example.firstapp.entities.Autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {
	
	
	@Query("SELECT a FROM Autor a WHERE a.id = :id")
	public Optional<Autor> findById(@Param("id") String id);
	
}