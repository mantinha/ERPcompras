package br.fsa.compras.service;

import java.util.Set;

import br.fsa.compras.model.RequisicaoDeCompras;

public interface RequisicaoDeComprasService {

	Set<RequisicaoDeCompras> getRequisicaoDeCompras();
	
	Set<RequisicaoDeCompras> postRequisicaoDeCompras();
	
}
