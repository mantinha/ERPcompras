package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.command.BloqueioCommand;
import br.fsa.compras.model.Bloqueio;
import br.fsa.compras.repository.BloqueioRepository;

@Service
public class BloqueioServiceImpl implements BloqueioService {
	
	private final BloqueioRepository bloqueioRepository;

	public BloqueioServiceImpl(BloqueioRepository bloqueioRepository) {
		this.bloqueioRepository = bloqueioRepository;
	}

	@Override
	public Set<Bloqueio> getBloqueio() {

		Set<Bloqueio> bloqueioSet = new HashSet<>();
		bloqueioRepository.findAll().iterator().forEachRemaining(bloqueioSet::add);
		return bloqueioSet;
	}

	@Override
	public Bloqueio findById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BloqueioCommand findCommandById(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BloqueioCommand saveBloqueioCommand(BloqueioCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long idToDelete) {
		// TODO Auto-generated method stub
		
	}

}
