package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.command.FornecedorCommand;
import br.fsa.compras.model.Fornecedor;
import br.fsa.compras.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {
	
	private final FornecedorRepository fornecedorRepository;	

	public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	@Override
	public Set<Fornecedor> getFornecedor() {

		Set<Fornecedor> fornecedorSet = new HashSet<>();
		fornecedorRepository.findAll().iterator().forEachRemaining(fornecedorSet::add);
		return fornecedorSet;
	}

	@Override
	public Fornecedor findById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FornecedorCommand findCommandById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FornecedorCommand saveFornecedorCommand(FornecedorCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long idToDelete) {
		// TODO Auto-generated method stub
		
	}

}
