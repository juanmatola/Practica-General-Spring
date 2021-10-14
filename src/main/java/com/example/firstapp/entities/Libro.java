package com.example.firstapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Libro {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private Long isbn;
	private String titulo;
	private Integer anio;
	private Integer ejemplares;
	private Integer ejemplaresprestados;
	private Integer ejemplaresrestantes;
	private Boolean alta;
	@ManyToOne
	private Autor autor;
	@ManyToOne
	private Editorial editorial;

	public Libro() {

	}

	public Libro(Long isbn, String titulo, Integer anio, 
				Integer ejemplares, Autor autor, Editorial editorial) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.anio = anio;
		this.ejemplares = ejemplares;
		this.ejemplaresprestados = 0;
		this.ejemplaresrestantes = ejemplares;
		this.alta = true;
		this.autor = autor;
		this.editorial = editorial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Integer getEjemplaresPrestados() {
		return ejemplaresprestados;
	}

	public void setEjemplaresPrestados(Integer ejemplaresprestados) {
		this.ejemplaresprestados = ejemplaresprestados;
	}

	public Integer getEjemplaresRestantes() {
		return ejemplaresrestantes;
	}

	public void setEjemplaresRestantes(Integer ejemplaresrestantes) {
		this.ejemplaresrestantes = ejemplaresrestantes;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

}
