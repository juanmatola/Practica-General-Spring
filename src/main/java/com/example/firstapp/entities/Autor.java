package com.example.firstapp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Autor {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid" , strategy = "uuid2")
	private String id;
	private String nombre;
	private Boolean alta;
	
	public Autor() {
		
	}		
	
	public Autor (String nombre) {
		this.nombre = nombre;
		this.alta = true;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean getAlta() {
		return alta;
	}
	
	public void setAlta(Boolean alta) {
		this.alta = alta;
	}
	
}