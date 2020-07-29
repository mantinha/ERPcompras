package br.fsa.compras.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fsa.compras.model.Bloqueio;

public interface BloqueioRepository extends JpaRepository<Bloqueio, Long> {

	Optional<Bloqueio> findByBloqueio(String bloqueio);
	
	Optional<Bloqueio> findByData(String data);
	
	Optional<Bloqueio> findByMotivo(String motivo);
}
