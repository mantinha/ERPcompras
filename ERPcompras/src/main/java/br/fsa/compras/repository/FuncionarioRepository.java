package br.fsa.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fsa.compras.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
