package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.command.FuncionarioCommand;
import br.fsa.compras.model.Funcionario;

public interface FuncionarioService {
	
	Set<Funcionario> getFuncionarios();
	
	Funcionario findById(Long l);
	
	FuncionarioCommand findCommandById(Long l);
	
	FuncionarioCommand saveFuncionarioCommand(FuncionarioCommand command);
	
	void deleteById(Long idToDelete);

}
