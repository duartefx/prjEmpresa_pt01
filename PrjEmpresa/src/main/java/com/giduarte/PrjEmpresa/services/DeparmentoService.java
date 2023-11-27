package com.giduarte.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giduarte.PrjEmpresa.entities.Departamento;
import com.giduarte.PrjEmpresa.repositories.DepartamentoRepository;
@Service
public class DeparmentoService {
	
private final DepartamentoRepository departamentoRepository;
	
	
	public DeparmentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository =  departamentoRepository;
	}
	
	// preparando as buscas por id
	public Departamento findDepartamentooById(Long depcodigo) {
		Optional <Departamento> Departamento = departamentoRepository.findById(depcodigo);
		return Departamento.orElse(null);
	}
	
	// preparando a busca geral
	public List<Departamento> findAllDepartamento() {
		return departamentoRepository.findAll();
	}
	
	// salvando 
		public Departamento insertDepartamento(Departamento dep) {
			return departamentoRepository.save(dep);
		}
	
		// fazendo o update 
		public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
			Optional<Departamento> depOptional = departamentoRepository.findById(depcodigo);
			if (depOptional.isPresent()) {
				Departamento depExistente = depOptional.get();
				depExistente.setName(novoDepartamento.getName());
				return departamentoRepository.save(depExistente);
			} else {
				return null;
			}
		}
		
		// deletando
		public boolean deleteDepartamento(Long depcodigo) {
			Optional<Departamento> depExistente = departamentoRepository.findById(depcodigo);
			if (depExistente.isPresent()) {
				departamentoRepository.deleteById(depcodigo);
				return true;
			} else {
				return false;
			}
		}
	
	
	

}
