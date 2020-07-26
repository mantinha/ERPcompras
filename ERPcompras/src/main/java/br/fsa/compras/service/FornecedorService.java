package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.command.FornecedorCommand;
import br.fsa.compras.model.Fornecedor;

public interface FornecedorService {
	
	Set<Fornecedor> getFornecedor();
	
	Fornecedor findById(Long l);
	
	FornecedorCommand findCommandById(Long l);
	
	FornecedorCommand saveFornecedorCommand(FornecedorCommand command);
	
	void deleteById(Long idToDelete);

}
