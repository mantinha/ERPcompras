package br.fsa.compras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.fsa.compras.model.Bloqueio;
import br.fsa.compras.model.Cargo;
import br.fsa.compras.model.Endereco;
import br.fsa.compras.model.Fornecedor;
import br.fsa.compras.model.Funcionario;
import br.fsa.compras.model.RequisicaoDeco;
import br.fsa.compras.model.Telefone;

@Configuration
public class ErPcomprasConfig {
	
	@Bean
	public Bloqueio bloqueio() { return new Bloqueio(); }
	
	@Bean
	public Cargo cargo() { return new Cargo(); }
	
	@Bean
	public Endereco endereco() { return new Endereco(); }
	
	@Bean
	public Fornecedor fornecedor() { return new Fornecedor(); }
	
	@Bean
	public Funcionario funcionario() { return new Funcionario(); }
	
	@Bean
	public RequisicaoDeco requisicaoDeco() { return new RequisicaoDeco(); }
	
	@Bean
	public Telefone telefone() { return new Telefone(); }

}
