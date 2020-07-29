package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.EnderecoCommand;
import br.fsa.compras.model.Endereco;

@Component
public class EnderecoCommandToEndereco implements Converter<EnderecoCommand, Endereco> {

	public EnderecoCommandToEndereco() {

	}

	@Nullable
	@Override
	public Endereco convert(EnderecoCommand source) {
		if(source == null) {
			return null;	
		}
		
		final Endereco endereco = new Endereco();
		
		endereco.setBairro(source.getBairro());
		endereco.setCep(source.getCep());
		endereco.setCidade(source.getCidade());
		endereco.setEstado(source.getEstado());
		endereco.setId(source.getId());
		endereco.setNumero(source.getNumero());
		endereco.setRua(source.getRua());
		
		return endereco;
	}

}
