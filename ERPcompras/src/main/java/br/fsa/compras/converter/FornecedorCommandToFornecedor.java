package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.FornecedorCommand;
import br.fsa.compras.model.Fornecedor;

@Component
public class FornecedorCommandToFornecedor implements Converter<FornecedorCommand, Fornecedor> {

	public FornecedorCommandToFornecedor() {

	}

	@Nullable
	@Override
	public Fornecedor convert(FornecedorCommand source) {
		if(source == null) {
			return null;	
		}
		
		final Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setCnpj(source.getCnpj());
		fornecedor.setData(source.getData());
		fornecedor.setId(source.getId());
		fornecedor.setMatricula(source.getMatricula());
		fornecedor.setNomeFantasia(source.getNomeFantasia());
		fornecedor.setRazaoSocial(source.getRazaoSocial());
		fornecedor.setSite(source.getSite());
		fornecedor.setStatus(source.getStatus());
		fornecedor.setTelefone(source.getTelefone());
		
		return fornecedor;
	}

}
