package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.command.RequisicaoDecoCommand;
import br.fsa.compras.model.RequisicaoDeco;

public interface RequisicaoDecoService {

	Set<RequisicaoDeco> getRequisicaoDeco();
	
	RequisicaoDeco findById(Long l);
	
	RequisicaoDecoCommand findCommandById(Long l);
	
	RequisicaoDecoCommand saveRequisicaoDecoCommand(RequisicaoDecoCommand command);
	
	void deleteById(Long idToDelete);
	
}
