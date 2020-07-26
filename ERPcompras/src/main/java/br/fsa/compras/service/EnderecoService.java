package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.command.EnderecoCommand;
import br.fsa.compras.model.Endereco;

public interface EnderecoService {
	
	Set<Endereco> getEndereco();
	
	Endereco findById(Long l);
	
	EnderecoCommand findCommandById(Long l);
	
	EnderecoCommand saveEnderecoCommand(EnderecoCommand command);
	
	void deleteById(Long idToDelete);

}
