package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.FuncionarioCommand;
import br.fsa.compras.model.Funcionario;

@Component
public class FuncionarioCommandToFuncionario implements Converter<FuncionarioCommand, Funcionario>{

	
	public FuncionarioCommandToFuncionario() {
		
	}
	
	@Nullable
	@Override
	public Funcionario convert(FuncionarioCommand source) {
		if(source == null) {
			return null;	
		}
		
		final Funcionario funcionario = new Funcionario();
		
		funcionario.setCargo(source.getCargo());
		funcionario.setDepartamento(source.getDepartamento());
		funcionario.setEmail(source.getEmail());
		funcionario.setId(source.getId());
		funcionario.setMatricula(source.getMatricula());
		funcionario.setNome(source.getNome());
		
		return funcionario;
	}

}
