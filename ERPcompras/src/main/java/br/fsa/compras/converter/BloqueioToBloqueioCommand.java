package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.BloqueioCommand;
import br.fsa.compras.model.Bloqueio;

@Component
public class BloqueioToBloqueioCommand implements Converter<Bloqueio, BloqueioCommand>{

	public BloqueioToBloqueioCommand() {

	}

	@Nullable
	@Override
	public BloqueioCommand convert(Bloqueio source) {
		if(source == null) {
			return null;	
		}
		
		final BloqueioCommand command = new BloqueioCommand();
		
		command.setBloqueio(source.getBloqueio());
		command.setData(source.getData());
		command.setId(source.getId());
		command.setMotivo(source.getMotivo());
		
		return command;
	}

}
