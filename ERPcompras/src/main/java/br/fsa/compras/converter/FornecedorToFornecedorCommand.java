package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.FornecedorCommand;
import br.fsa.compras.model.Fornecedor;

@Component
public class FornecedorToFornecedorCommand implements Converter<Fornecedor, FornecedorCommand> {

	public FornecedorToFornecedorCommand() {

	}

	@Nullable
	@Override
	public FornecedorCommand convert(Fornecedor source) {
		if(source == null) {
			return null;	
		}
		
		final FornecedorCommand command = new FornecedorCommand();
		
		command.setCnpj(source.getCnpj());
		command.setData(source.getData());
		command.setId(source.getId());
		command.setMatricula(source.getMatricula());
		command.setNomeFantasia(source.getNomeFantasia());
		command.setRazaoSocial(source.getRazaoSocial());
		command.setSite(source.getSite());
		command.setStatus(source.getStatus());
		command.setTelefone(source.getTelefone());
		
		return command;
	}

}
