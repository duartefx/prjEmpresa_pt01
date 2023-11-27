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

import com.giduarte.PrjEmpresa.entities.Departamento;
import com.giduarte.PrjEmpresa.services.DeparmentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="Departamentos", description = "API REST DE GERENCIAMENTO DO DEPARTAMENTO")
@RestController
@RequestMapping("/departamento")
public class DeparmentoController {
		
		private final DeparmentoService departamentoService;

		@Autowired
		public DeparmentoController(DeparmentoService departamentoService) {
			this.departamentoService = departamentoService;
		}

		//procurar pelo id
		@GetMapping("/{depcodigo}")
		@Operation(summary = "Localiza usuário por ID")
		public ResponseEntity<Departamento> findDepartamentobyId(@PathVariable Long depcodigo) {
			Departamento departamento = departamentoService.findDepartamentooById(depcodigo);
			if (departamento != null) {
				return ResponseEntity.ok(departamento);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		
		//procurar
		@GetMapping("/")
		@Operation(summary ="Apresentar")
		public ResponseEntity<List<Departamento>> findAllDepartamentocontrol() {
			List<Departamento> deps = departamentoService.findAllDepartamento();
			return ResponseEntity.ok(deps);
		}

		
		//insert
		@PostMapping("/")
		@Operation(summary = "Cadastra")
		public ResponseEntity<Departamento> insertDepartamentosControl(@RequestBody @Valid Departamento departamento) {
			Departamento novoDepart = departamentoService.insertDepartamento(departamento);
			return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
		}

	
		//update
		@PutMapping("/{depcodigo}")
		@Operation(summary = "Alterar")
		public ResponseEntity<Departamento> updateDepartamentoControl(@PathVariable Long depcodigo, @RequestBody @Valid Departamento departamento) {
			Departamento mudaDepart = departamentoService.updateDepartamento(depcodigo, departamento);
			if (mudaDepart != null) {
				return ResponseEntity.ok(departamento);
			} else {
				return ResponseEntity.notFound().build();
			}
		}


		//deletar
		@DeleteMapping("/{depcodigo}")
		@Operation(summary = "Excluir")
		public ResponseEntity<String> deleteDepartamentoControl(@PathVariable Long depcodigo) {
			boolean remover = departamentoService.deleteDepartamento(depcodigo);
			if (remover) {
				return ResponseEntity.ok().body("Excluído com sucesso");
			} else {
				return ResponseEntity.notFound().build();
			}
		}

}
