package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.command.TelefoneCommand;
import br.fsa.compras.model.Telefone;
import br.fsa.compras.repository.TelefoneRepository;

@Service
public class TelefoneServiceImpl implements TelefoneService {
	
	private final TelefoneRepository telefoneRepository;

	public TelefoneServiceImpl(TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
	}

	@Override
	public Set<Telefone> getTelefoneDeco() {
		
		Set<Telefone> telefoneSet = new HashSet<>();
		telefoneRepository.findAll().iterator().forEachRemaining(telefoneSet::add);
		return telefoneSet;
	}

	@Override
	public Telefone findById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TelefoneCommand findCommandById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TelefoneCommand saveTelefoneCommand(TelefoneCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long idToDelete) {
		// TODO Auto-generated method stub
		
	}

}
