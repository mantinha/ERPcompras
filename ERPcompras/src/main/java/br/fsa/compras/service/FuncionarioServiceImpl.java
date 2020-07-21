package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.model.Funcionario;
import br.fsa.compras.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	
	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {	
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	public Set<Funcionario> getFuncionarios() {
		
		Set<Funcionario> funcionarioSet = new HashSet<>();
		funcionarioRepository.findAll().iterator().forEachRemaining(funcionarioSet::add);
		return funcionarioSet;
	}

}
