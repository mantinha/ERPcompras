package br.fsa.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fsa.compras.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
