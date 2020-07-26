package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.command.TelefoneCommand;
import br.fsa.compras.model.Telefone;

public interface TelefoneService {
	
	Set<Telefone> getTelefoneDeco();
	
	Telefone findById(Long l);
	
	TelefoneCommand findCommandById(Long l);
	
	TelefoneCommand saveTelefoneCommand(TelefoneCommand command);
	
	void deleteById(Long idToDelete);

}
