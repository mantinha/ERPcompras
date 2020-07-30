package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fsa.compras.command.MateriaPrimaCommand;
import br.fsa.compras.converter.MateriaPrimaCommandToMateriaPrima;
import br.fsa.compras.converter.MateriaPrimaToMateriaPrimaCommand;
import br.fsa.compras.model.MateriaPrima;
import br.fsa.compras.repository.MateriaPrimaRepository;

@Service
public class MateriaPrimaServiceImpl implements MateriaPrimaService {
	
	private final MateriaPrimaRepository materiaPrimaRepository;
	private final MateriaPrimaCommandToMateriaPrima materiaPrimaCommandToMateriaPrima;
	private final MateriaPrimaToMateriaPrimaCommand materiaPrimaToMateriaPrimaCommand;
	
	public MateriaPrimaServiceImpl(MateriaPrimaRepository materiaPrimaRepository,
			MateriaPrimaCommandToMateriaPrima materiaPrimaCommandToMateriaPrima,
			MateriaPrimaToMateriaPrimaCommand materiaPrimaToMateriaPrimaCommand) {
		this.materiaPrimaRepository = materiaPrimaRepository;
		this.materiaPrimaCommandToMateriaPrima = materiaPrimaCommandToMateriaPrima;
		this.materiaPrimaToMateriaPrimaCommand = materiaPrimaToMateriaPrimaCommand;
	}

	@Override
	public Set<MateriaPrima> getMateriaPrima() {
		Set<MateriaPrima> materiaPrimaSet = new HashSet<>();
		
		materiaPrimaRepository.findAll().iterator().forEachRemaining(materiaPrimaSet::add);
		return materiaPrimaSet;
	}

	@Override
	public MateriaPrima findById(Long l) {
		Optional<MateriaPrima> materiaPrimaOptional = materiaPrimaRepository.findById(l);
		
		if(!materiaPrimaOptional.isPresent()) {
			throw new RuntimeException("Matéria Prima não encontrada! Para o id: " + l.toString());
		}
		
		return materiaPrimaOptional.get();
	}

	@Override
	@Transactional
	public MateriaPrimaCommand findCommandById(Long l) {
		return materiaPrimaToMateriaPrimaCommand.convert(findById(l));
	}

	@Override
	@Transactional
	public MateriaPrimaCommand saveMateriaPrimaCommand(MateriaPrimaCommand command) {
		MateriaPrima detachedMateriaPrima = materiaPrimaCommandToMateriaPrima.convert(command);
		MateriaPrima savedMateriaPrima = materiaPrimaRepository.save(detachedMateriaPrima);
		
		return materiaPrimaToMateriaPrimaCommand.convert(savedMateriaPrima);
	}

	@Override
	public void deleteById(Long idToDelete) {
		materiaPrimaRepository.deleteById(idToDelete);
		
	}

}
