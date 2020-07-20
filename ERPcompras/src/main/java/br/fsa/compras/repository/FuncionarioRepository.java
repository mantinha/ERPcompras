package br.fsa.compras.repository;

import org.springframework.data.repository.CrudRepository;

import br.fsa.compras.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}
