package br.fsa.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fsa.compras.model.Bloqueio;

@Repository
public interface BloqueioRepository extends JpaRepository<Bloqueio, Long> {

}
