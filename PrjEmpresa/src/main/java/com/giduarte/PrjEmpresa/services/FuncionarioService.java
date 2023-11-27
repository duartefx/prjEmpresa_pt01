package com.giduarte.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.giduarte.PrjEmpresa.entities.Funcionario;
import com.giduarte.PrjEmpresa.repositories.FuncionarioRepository;


@Service
public class FuncionarioService {

private final FuncionarioRepository funcionarioRepository;
	
	
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository =  funcionarioRepository;
	}
	
	// preparando as buscas por id
	public Funcionario findFuncionarioById(Long funcodigo) {
		Optional <Funcionario> Funcionario = funcionarioRepository.findById(funcodigo);
		return Funcionario.orElse(null);
	}
	
	// preparando a busca geral
	public List<Funcionario> findAllFuncionario() {
		return funcionarioRepository.findAll();
	}
	
	// salvando 
		public Funcionario insertFuncionario(Funcionario fun) {
			return funcionarioRepository.save(fun);
		}
	
		// fazendo o update 
		public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
			Optional<Funcionario> funOptional = funcionarioRepository.findById(funcodigo);
			if (funOptional.isPresent()) {
				Funcionario funExistente = funOptional.get();
				funExistente.setName(novoFuncionario.getName());
				return funcionarioRepository.save(funExistente);
			} else {
				return null;
			}
		}
		
		// deletando
		public boolean deleteFuncionario(Long funcodigo) {
			Optional<Funcionario> funExistente = funcionarioRepository.findById(funcodigo);
			if (funExistente.isPresent()) {
				funcionarioRepository.deleteById(funcodigo);
				return true;
			} else {
				return false;
			}
		}
	
}

