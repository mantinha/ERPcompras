package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.fsa.compras.command.FuncionarioCommand;
import br.fsa.compras.converter.FuncionarioCommandToFuncionario;
import br.fsa.compras.converter.FuncionarioToFuncionarioCommand;
import br.fsa.compras.model.Funcionario;
import br.fsa.compras.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	private final FuncionarioCommandToFuncionario funcionarioCommandToFuncionario;
	private final FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;

	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository,
			FuncionarioCommandToFuncionario funcionarioCommandToFuncionario,
			FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand) {
		this.funcionarioRepository = funcionarioRepository;
		this.funcionarioCommandToFuncionario = funcionarioCommandToFuncionario;
		this.funcionarioToFuncionarioCommand = funcionarioToFuncionarioCommand;
	}

	@Override
	public Set<Funcionario> getFuncionarios() {		
		Set<Funcionario> funcionarioSet = new HashSet<>();
		
		funcionarioRepository.findAll().iterator().forEachRemaining(funcionarioSet::add);
		return funcionarioSet;
	}

	@Override
	public Funcionario findById(Long l) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(l);
		
		if(!funcionarioOptional.isPresent()) {
			throw new RuntimeException("Funcionário não encontrada! Para o id: " + l.toString());
		}
		
		return funcionarioOptional.get();
	}
	
	@Transactional
	@Override
	public FuncionarioCommand findCommandById(Long l) {
		return funcionarioToFuncionarioCommand.convert(findById(l));
	}
	
	@Transactional
	@Override
	public FuncionarioCommand saveFuncionarioCommand(FuncionarioCommand command) {
		Funcionario detachedFuncionario = funcionarioCommandToFuncionario.convert(command);
		Funcionario savedFuncionario = funcionarioRepository.save(detachedFuncionario);
		
		return funcionarioToFuncionarioCommand.convert(savedFuncionario);
	}

	@Override
	public void deleteById(Long idToDelete) {
		funcionarioRepository.deleteById(idToDelete);
		
	}

}
