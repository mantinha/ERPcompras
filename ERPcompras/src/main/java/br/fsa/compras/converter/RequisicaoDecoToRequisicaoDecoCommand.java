package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.RequisicaoDecoCommand;
import br.fsa.compras.model.RequisicaoDeco;

@Component
public class RequisicaoDecoToRequisicaoDecoCommand implements Converter<RequisicaoDeco, RequisicaoDecoCommand> {

	public RequisicaoDecoToRequisicaoDecoCommand() {

	}

	@Nullable
	@Override
	public RequisicaoDecoCommand convert(RequisicaoDeco source) {
		if(source == null) {
			return null;	
		}
		
		final RequisicaoDecoCommand command = new RequisicaoDecoCommand();
		
		command.setCentroDeCusto(source.getCentroDeCusto());
		command.setCodigo(source.getCodigo());
		command.setCodigoMateriaPrima(source.getCodigoMateriaPrima());
		command.setData(source.getData());
		command.setDataPrevista(source.getDataPrevista());
		command.setId(source.getId());
		command.setMatricula(source.getMatricula());
		command.setMatriculaAprovador(source.getMatriculaAprovador());
		command.setQtdRequisitada(source.getQtdRequisitada());
		
		return command;
	}

}
