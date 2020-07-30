package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.MateriaPrimaCommand;
import br.fsa.compras.model.MateriaPrima;

@Component
public class MateriaPrimaCommandToMateriaPrima implements Converter<MateriaPrimaCommand, MateriaPrima>{

	@Nullable
	@Override
	public MateriaPrima convert(MateriaPrimaCommand source) {
		if(source == null) {
			return null;	
		}

		MateriaPrima materiaPrima = new MateriaPrima();
		
		materiaPrima.setCodigo(source.getCodigo());
		materiaPrima.setDescricao(source.getDescricao());
		materiaPrima.setId(source.getId());
		materiaPrima.setQuantidade(source.getQuantidade());
		materiaPrima.setUnidadeDeMedida(source.getUnidadeDeMedida());
		
		return materiaPrima;
	}

}
