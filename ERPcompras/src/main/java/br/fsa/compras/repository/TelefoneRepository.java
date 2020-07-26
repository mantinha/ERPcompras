package br.fsa.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fsa.compras.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
