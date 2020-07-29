package br.fsa.compras.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fsa.compras.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long>{
	
	Optional<Cargo> findByNome(String nome);

}
