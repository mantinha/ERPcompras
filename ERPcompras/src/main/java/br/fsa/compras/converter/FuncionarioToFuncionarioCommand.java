package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.FuncionarioCommand;
import br.fsa.compras.model.Funcionario;

@Component
public class FuncionarioToFuncionarioCommand implements Converter<Funcionario, FuncionarioCommand>{

	
	public FuncionarioToFuncionarioCommand() {
		
	}
	
	@Nullable
	@Override
	public FuncionarioCommand convert(Funcionario source) {
		if(source == null) {
			return null;	
		}
		
		final FuncionarioCommand command = new FuncionarioCommand();
		
		command.setCargo(source.getCargo());
		command.setDepartamento(source.getDepartamento());
		command.setEmail(source.getEmail());
		command.setId(source.getId());
		command.setMatricula(source.getMatricula());
		command.setNome(source.getNome());
		
		return command;
	}

}
