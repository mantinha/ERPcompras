package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.command.BloqueioCommand;
import br.fsa.compras.model.Bloqueio;

public interface BloqueioService {
	
	Set<Bloqueio> getBloqueio();
	
	Bloqueio findById(Long l);
	
	BloqueioCommand findCommandById(Long l);
	
	BloqueioCommand saveBloqueioCommand(BloqueioCommand command);
	
	void deleteById(Long idToDelete);

}
