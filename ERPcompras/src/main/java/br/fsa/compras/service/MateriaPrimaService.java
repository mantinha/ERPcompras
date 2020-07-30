package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.command.MateriaPrimaCommand;
import br.fsa.compras.model.MateriaPrima;

public interface MateriaPrimaService {
	
	Set<MateriaPrima> getMateriaPrima();
	
	MateriaPrima findById(Long l);
	
	MateriaPrimaCommand findCommandById(Long l);
	
	MateriaPrimaCommand saveMateriaPrimaCommand(MateriaPrimaCommand command);
	
	void deleteById(Long idToDelete);
	
}
