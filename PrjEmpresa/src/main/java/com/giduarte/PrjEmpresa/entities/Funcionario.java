package com.giduarte.PrjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;
	
	private String funnome;
	private Double funsalario;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	   private LocalDate funnascimento;
	
	
	//getts
	public Long getId() {
		return funcodigo;
	}
	
	public String getName() {
		return funnome;
	}
	
	public Double getSalario() {
		return funsalario;
	}
	
	public LocalDate getData() {
		return funnascimento;
	}
	
	//setts
	public void setId(Long funcodigo) {
		this.funcodigo = funcodigo;
	}
	
	public void setName (String funnome) {
		this.funnome = funnome;
	}
	
	public void setSalario(Double funsalario) {
		this.funsalario = funsalario;
	}
	
	public void setData(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}
}
