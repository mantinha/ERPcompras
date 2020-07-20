package br.fsa.compras.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.fsa.compras.model.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long>{
	
	Optional<Departamento> findByNome(String nome);

}
