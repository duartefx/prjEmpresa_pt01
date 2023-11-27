package com.giduarte.PrjEmpresa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depcodigo;
	
	private String depnome;
	
	
	//getts
	public Long getId(){
		return depcodigo;
	}
	
	public String getName(){
		return depnome;
	}
	
	//setts
	public void setId(Long depcodigo) {
		this.depcodigo = depcodigo;
	}
	
	public void setName(String depnome) {
		this.depnome = depnome;
	}
}

