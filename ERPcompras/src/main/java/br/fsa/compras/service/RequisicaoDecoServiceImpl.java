package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fsa.compras.command.RequisicaoDecoCommand;
import br.fsa.compras.converter.RequisicaoDecoCommandToRequisicaoDeco;
import br.fsa.compras.converter.RequisicaoDecoToRequisicaoDecoCommand;
import br.fsa.compras.model.RequisicaoDeco;
import br.fsa.compras.repository.RequisicaoDecoRepository;

@Service
public class RequisicaoDecoServiceImpl implements RequisicaoDecoService {

	private final RequisicaoDecoRepository requisicaoDecoRepository;
	private final RequisicaoDecoCommandToRequisicaoDeco requisicaoDecoCommandToRequisicaoDeco;
	private final RequisicaoDecoToRequisicaoDecoCommand requisicaoDecoToRequisicaoDecoCommand;

	public RequisicaoDecoServiceImpl(RequisicaoDecoRepository requisicaoDecoRepository,
			RequisicaoDecoCommandToRequisicaoDeco requisicaoDecoCommandToRequisicaoDeco,
			RequisicaoDecoToRequisicaoDecoCommand requisicaoDecoToRequisicaoDecoCommand) {
		this.requisicaoDecoRepository = requisicaoDecoRepository;
		this.requisicaoDecoCommandToRequisicaoDeco = requisicaoDecoCommandToRequisicaoDeco;
		this.requisicaoDecoToRequisicaoDecoCommand = requisicaoDecoToRequisicaoDecoCommand;
	}

	@Override
	public Set<RequisicaoDeco> getRequisicaoDeco() {
		
		Set<RequisicaoDeco> requisicaoDecoSet = new HashSet<>();
		requisicaoDecoRepository.findAll().iterator().forEachRemaining(requisicaoDecoSet::add);

		return requisicaoDecoSet;
	}
	
	@Override
	public RequisicaoDeco findById(Long l) {
		
		Optional<RequisicaoDeco> requisicaoOptional = requisicaoDecoRepository.findById(l);
		
		if(!requisicaoOptional.isPresent()) {
			throw new RuntimeException("Requisição não encontrada! Para o id: " + l.toString());
		}
		
		return requisicaoOptional.get();
	}
	
	@Override
	public RequisicaoDecoCommand findCommandById(Long l) {
		return requisicaoDecoToRequisicaoDecoCommand.convert(findById(l));
	}

	@Override
	@Transactional
	public RequisicaoDecoCommand saveRequisicaoDecoCommand(RequisicaoDecoCommand command) {
		
		RequisicaoDeco detachedRequisicaoDeco = requisicaoDecoCommandToRequisicaoDeco.convert(command);
		RequisicaoDeco savedRequisicaoDeco = requisicaoDecoRepository.save(detachedRequisicaoDeco);
		
		return requisicaoDecoToRequisicaoDecoCommand.convert(savedRequisicaoDeco);
	}

	@Override
	public void deleteById(Long idToDelete) {
		
		requisicaoDecoRepository.deleteById(idToDelete);
		
	}
	
}
