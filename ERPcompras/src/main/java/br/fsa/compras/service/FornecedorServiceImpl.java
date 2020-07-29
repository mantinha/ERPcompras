package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fsa.compras.command.FornecedorCommand;
import br.fsa.compras.converter.FornecedorCommandToFornecedor;
import br.fsa.compras.converter.FornecedorToFornecedorCommand;
import br.fsa.compras.model.Fornecedor;
import br.fsa.compras.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {
	
	private final FornecedorRepository fornecedorRepository;
	private final FornecedorCommandToFornecedor fornecedorCommandToFornecedor;
	private final FornecedorToFornecedorCommand fornecedorToFornecedorCommand;

	public FornecedorServiceImpl(FornecedorRepository fornecedorRepository,
			FornecedorCommandToFornecedor fornecedorCommandToFornecedor,
			FornecedorToFornecedorCommand fornecedorToFornecedorCommand) {
		this.fornecedorRepository = fornecedorRepository;
		this.fornecedorCommandToFornecedor = fornecedorCommandToFornecedor;
		this.fornecedorToFornecedorCommand = fornecedorToFornecedorCommand;
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
	@Transactional
	public FornecedorCommand saveFornecedorCommand(FornecedorCommand command) {
		Fornecedor detachedFornecedor = fornecedorCommandToFornecedor.convert(command);
		Fornecedor savedFornecedor = fornecedorRepository.save(detachedFornecedor);
		
		return fornecedorToFornecedorCommand.convert(savedFornecedor);
	}

	@Override
	public void deleteById(Long idToDelete) {
		// TODO Auto-generated method stub
		
	}

}
