package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.model.Departamento;
import br.fsa.compras.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	private final DepartamentoRepository departamentoRepository;
		
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public Set<Departamento> getDepartamentos() {
		
		Set<Departamento> departamentoSet = new HashSet<>();
		departamentoRepository.findAll().iterator().forEachRemaining(departamentoSet::add);
		return departamentoSet;
	}

}
