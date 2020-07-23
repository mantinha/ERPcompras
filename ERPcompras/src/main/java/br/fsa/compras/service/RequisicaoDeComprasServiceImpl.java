package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.model.RequisicaoDeCompras;
import br.fsa.compras.repository.RequisicaoDeComprasRepository;

@Service
public class RequisicaoDeComprasServiceImpl implements RequisicaoDeComprasService {

	private final RequisicaoDeComprasRepository requisicaoDeComprasRepository;
	
	public RequisicaoDeComprasServiceImpl(RequisicaoDeComprasRepository requisicaoDeComprasRepository) {
		this.requisicaoDeComprasRepository = requisicaoDeComprasRepository;
	}

	@Override
	public Set<RequisicaoDeCompras> getRequisicaoDeCompras() {
		
		Set<RequisicaoDeCompras> requisicaoDeComprasSet = new HashSet<>();
		requisicaoDeComprasRepository.findAll().iterator().forEachRemaining(requisicaoDeComprasSet::add);

		return requisicaoDeComprasSet;
	}

}
