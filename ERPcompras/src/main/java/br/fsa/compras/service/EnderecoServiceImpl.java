package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.command.EnderecoCommand;
import br.fsa.compras.model.Endereco;
import br.fsa.compras.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	private final EnderecoRepository enderecoRepository;
	
	public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	public Set<Endereco> getEndereco() {
		
		Set<Endereco> enderecoSet = new HashSet<>();
		enderecoRepository.findAll().iterator().forEachRemaining(enderecoSet::add);
		return enderecoSet;
	}

	@Override
	public Endereco findById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoCommand findCommandById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoCommand saveEnderecoCommand(EnderecoCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long idToDelete) {
		// TODO Auto-generated method stub
		
	}

}
