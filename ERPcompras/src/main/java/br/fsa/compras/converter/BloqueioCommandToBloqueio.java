package br.fsa.compras.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.fsa.compras.command.BloqueioCommand;
import br.fsa.compras.model.Bloqueio;

@Component
public class BloqueioCommandToBloqueio implements Converter<BloqueioCommand, Bloqueio>{

	public BloqueioCommandToBloqueio() {
		
	}

	@Nullable
	@Override
	public Bloqueio convert(BloqueioCommand source) {
		if(source == null) {
			return null;	
		}
		
		final Bloqueio bloqueio = new Bloqueio();
		
		bloqueio.setBloqueio(source.getBloqueio());
		bloqueio.setData(source.getData());
		bloqueio.setId(source.getId());
		bloqueio.setMotivo(source.getMotivo());
		
		return bloqueio;
	}

}
