package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fsa.compras.command.EnderecoCommand;
import br.fsa.compras.converter.EnderecoCommandToEndereco;
import br.fsa.compras.converter.EnderecoToEnderecoCommand;
import br.fsa.compras.model.Endereco;
import br.fsa.compras.repository.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	private final EnderecoRepository enderecoRepository;
	private final EnderecoCommandToEndereco enderecoCommandToEndereco;
	private final EnderecoToEnderecoCommand enderecoToEnderecoCommand;

	public EnderecoServiceImpl(EnderecoRepository enderecoRepository,
			EnderecoCommandToEndereco enderecoCommandToEndereco, EnderecoToEnderecoCommand enderecoToEnderecoCommand) {
		this.enderecoRepository = enderecoRepository;
		this.enderecoCommandToEndereco = enderecoCommandToEndereco;
		this.enderecoToEnderecoCommand = enderecoToEnderecoCommand;
	}

	@Override
	public Set<Endereco> getEndereco() {		
		Set<Endereco> enderecoSet = new HashSet<>();
		
		enderecoRepository.findAll().iterator().forEachRemaining(enderecoSet::add);
		return enderecoSet;
	}

	@Override
	public Endereco findById(Long l) {
		Optional<Endereco> enderecoOptional = enderecoRepository.findById(l);
		
		if(!enderecoOptional.isPresent()) {
			throw new RuntimeException("Endereco não encontrado! Para o id: " + l.toString());
		}
		return enderecoOptional.get();
	}

	@Override
	@Transactional
	public EnderecoCommand findCommandById(Long l) {		
		return enderecoToEnderecoCommand.convert(findById(l));
	}

	@Override
	public EnderecoCommand saveEnderecoCommand(EnderecoCommand command) {
		Endereco detachedEndereco = enderecoCommandToEndereco.convert(command);
		Endereco savedEndereco = enderecoRepository.save(detachedEndereco);
		
		return enderecoToEnderecoCommand.convert(savedEndereco);
	}

	@Override
	public void deleteById(Long idToDelete) {
		enderecoRepository.deleteById(idToDelete);
		
	}

}
