package com.giduarte.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.giduarte.PrjEmpresa.entities.Funcionario;


public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {

}
