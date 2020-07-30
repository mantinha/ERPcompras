package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.MateriaPrimaCommand;
import br.fsa.compras.model.MateriaPrima;

@Component
public class MateriaPrimaToMateriaPrimaCommand implements Converter<MateriaPrima, MateriaPrimaCommand>{

	@Nullable
	@Override
	public MateriaPrimaCommand convert(MateriaPrima source) {
		if(source == null) {
			return null;	
		}

		final MateriaPrimaCommand command = new MateriaPrimaCommand();
		
		command.setCodigo(source.getCodigo());
		command.setDescricao(source.getDescricao());
		command.setId(source.getId());
		command.setQuantidade(source.getQuantidade());
		command.setUnidadeDeMedida(source.getUnidadeDeMedida());
		
		return command;
	}

}
