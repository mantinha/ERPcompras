package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.RequisicaoDecoCommand;
import br.fsa.compras.model.RequisicaoDeco;

@Component
public class RequisicaoDecoCommandToRequisicaoDeco implements Converter<RequisicaoDecoCommand, RequisicaoDeco> {	

	public RequisicaoDecoCommandToRequisicaoDeco() {
	
	}

	@Nullable
	@Override
	public RequisicaoDeco convert(RequisicaoDecoCommand source) {
		if(source == null) {
			return null;	
		}
		
		final RequisicaoDeco requisicaoDeco = new RequisicaoDeco();
		
		requisicaoDeco.setCentroDeCusto(source.getCentroDeCusto());
		requisicaoDeco.setCodigo(source.getCodigo());
		requisicaoDeco.setCodigoMateriaPrima(source.getCodigoMateriaPrima());
		requisicaoDeco.setData(source.getData());
		requisicaoDeco.setDataPrevista(source.getDataPrevista());
		requisicaoDeco.setId(source.getId());
		requisicaoDeco.setMatricula(source.getMatricula());
		requisicaoDeco.setMatriculaAprovador(source.getMatriculaAprovador());
		requisicaoDeco.setQtdRequisitada(source.getQtdRequisitada());
		
		return requisicaoDeco;
	}

}
