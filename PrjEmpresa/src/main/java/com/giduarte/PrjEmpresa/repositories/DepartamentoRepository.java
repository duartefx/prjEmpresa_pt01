package com.giduarte.PrjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.giduarte.PrjEmpresa.entities.Departamento;


public interface DepartamentoRepository extends JpaRepository <Departamento, Long> {

}
