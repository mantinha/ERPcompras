package br.fsa.compras.repository;

import org.springframework.data.repository.CrudRepository;

import br.fsa.compras.model.Fornecedor;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

}
