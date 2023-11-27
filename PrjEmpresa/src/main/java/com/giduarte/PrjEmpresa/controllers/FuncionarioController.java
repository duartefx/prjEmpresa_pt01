package com.giduarte.PrjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giduarte.PrjEmpresa.entities.Funcionario;
import com.giduarte.PrjEmpresa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="funcionarios", description = "API REST DE GERENCIAMENTO DE FUNCIONARIOS")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
			
			private final FuncionarioService funcionarioService;

			@Autowired
			public FuncionarioController(FuncionarioService funcionarioService) {
				this.funcionarioService = funcionarioService;
			}

			//procurar pelo id
			@GetMapping("/{funcodigo}")
			@Operation(summary = "Localiza usuário por ID")
			public ResponseEntity<Funcionario> findFuncionariobyId(@PathVariable Long funcodigo) {
				Funcionario funcionario = funcionarioService.findFuncionarioById(funcodigo);
				if (funcionario != null) {
					return ResponseEntity.ok(funcionario);
				} else {
					return ResponseEntity.notFound().build();
				}
			}

			
			//procurar
			@GetMapping("/")
			@Operation(summary ="Apresentar")
			public ResponseEntity<List<Funcionario>> findAllFuncionariocontrol() {
				List<Funcionario> deps = funcionarioService.findAllFuncionario();
				return ResponseEntity.ok(deps);
			}

			
			//insert
			@PostMapping("/")
			@Operation(summary = "Cadastra")
			public ResponseEntity<Funcionario> insertFuncionariosControl(@RequestBody @Valid Funcionario funcionario) {
				Funcionario novoFuncionario = funcionarioService.insertFuncionario(funcionario);
				return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
			}

		
			//update
			@PutMapping("/{funcodigo}")
			@Operation(summary = "Alterar")
			public ResponseEntity<Funcionario> updateFuncionarioControl(@PathVariable Long funcodigo, @RequestBody @Valid Funcionario funcionario) {
				Funcionario mudaFuncionario = funcionarioService.updateFuncionario(funcodigo, funcionario);
				if (mudaFuncionario != null) {
					return ResponseEntity.ok(funcionario);
				} else {
					return ResponseEntity.notFound().build();
				}
			}


			//deletar
			@DeleteMapping("/{funcodigo}")
			@Operation(summary = "Excluir")
			public ResponseEntity<String> deleteFuncionarioControl(@PathVariable Long funcodigo) {
				boolean remover = funcionarioService.deleteFuncionario(funcodigo);
				if (remover) {
					return ResponseEntity.ok().body("Excluído com sucesso");
				} else {
					return ResponseEntity.notFound().build();
				}
			}

}
