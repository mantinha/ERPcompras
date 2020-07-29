package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;

import br.fsa.compras.command.EnderecoCommand;
import br.fsa.compras.model.Endereco;

@Controller
public class EnderecoToEnderecoCommand implements Converter<Endereco, EnderecoCommand>{

	public EnderecoToEnderecoCommand() {

	}

	@Nullable
	@Override
	public EnderecoCommand convert(Endereco source) {
		if(source == null) {
			return null;	
		}
		
		final EnderecoCommand command = new EnderecoCommand();
		
		command.setBairro(source.getBairro());
		command.setCep(source.getCep());
		command.setCidade(source.getCidade());
		command.setEstado(source.getEstado());
		command.setId(source.getId());
		command.setNumero(source.getNumero());
		command.setRua(source.getRua());
		
		return command;
	}

}
