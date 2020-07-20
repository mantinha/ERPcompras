package br.fsa.compras.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.fsa.compras.model.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Long>{
	
	Optional<Cargo> findByNome(String nome);

}
