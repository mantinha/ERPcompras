package br.fsa.compras.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.fsa.compras.model.Cargo;
import br.fsa.compras.model.Departamento;
import br.fsa.compras.model.Funcionario;
import br.fsa.compras.repository.CargoRepository;
import br.fsa.compras.repository.DepartamentoRepository;
import br.fsa.compras.repository.FuncionarioRepository;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent>{
	
	private final DepartamentoRepository departamentoRepository;
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	
	public BootstrapData(DepartamentoRepository departamentoRepository, CargoRepository cargoRepository, FuncionarioRepository funcionarioRepository) {
		this.departamentoRepository = departamentoRepository;
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		/*
		 * Save Data
		 */		
		funcionarioRepository.saveAll(getFuncionarios());
		
		System.out.println("Cargos registrados: " + cargoRepository.count());
		System.out.println("Departamentos registrados: " + departamentoRepository.count());
		System.out.println("Funcionarios registrados " + funcionarioRepository.count());
	}
	
	private List<Funcionario> getFuncionarios() {
		
		List<Funcionario> funcionarios = new ArrayList<>(2);
		
		/*
		 * Input Data Funcionario
		 */
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Adriano");
		funcionario1.setEmail("adriano.santana@ads.fsa.br");
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Erick Ticianeli Krywko");
		funcionario2.setEmail("erick.krywko@ads.fsa.br");
		
		Funcionario funcionario3 = new Funcionario();
		funcionario3.setNome("Pedro Ivo Ramos de Oliveira");
		funcionario3.setEmail("pedro.oliveira@ads.fsa.br");
		
		/*
		 * Get Data Cargo
		 */
		Optional<Cargo> aprovadorCargoOptional = cargoRepository.findByNome("Aprovador");		
		if(!aprovadorCargoOptional.isPresent()) {
			throw new RuntimeException("Cargo não encontrado!");
		}
		
		Optional<Cargo> compradorCargoOptional = cargoRepository.findByNome("Comprador");		
		if(!compradorCargoOptional.isPresent()) {
			throw new RuntimeException("Cargo não encontrado!");
		}
		
		Optional<Cargo> gerenteCargoOptional = cargoRepository.findByNome("Gerente");		
		if(!gerenteCargoOptional.isPresent()) {
			throw new RuntimeException("Cargo não encontrado!");
		}
		
		Cargo aprovador = aprovadorCargoOptional.get();
		Cargo comprador = compradorCargoOptional.get();
		Cargo gerente = gerenteCargoOptional.get();
		
		/*
		 * Relationships OneToOne {Cargo} --> {Funcionario}
		 */
		funcionario1.setCargo(gerente);
		funcionario2.setCargo(aprovador);
		funcionario3.setCargo(comprador);
		aprovador.setFuncionario(funcionario2);
		comprador.setFuncionario(funcionario3);
		gerente.setFuncionario(funcionario1);
		
		/*
		 * Get Data Departamento
		 */
		Optional<Departamento> comprasDepartamentoOptional = departamentoRepository.findByNome("Compras");
		if(!comprasDepartamentoOptional.isPresent()) {
			throw new RuntimeException("Departamento não encontrado!");
		}
		
		Optional<Departamento> financeiroDepartamentoOptional = departamentoRepository.findByNome("Financeiro");
		if(!financeiroDepartamentoOptional.isPresent()) {
			throw new RuntimeException("Departamento não encontrado!");
		}
		
		Departamento compras = comprasDepartamentoOptional.get();
		Departamento financeiro = financeiroDepartamentoOptional.get();
		
		/*
		 * Relationships OneToOne {Departamento} --> {Funcionario}
		 */
		funcionario1.setDepartamento(compras);
		funcionario2.setDepartamento(compras);
		funcionario3.setDepartamento(financeiro);		
		compras.setFuncionario(funcionario1);
		compras.setFuncionario(funcionario2);
		financeiro.setFuncionario(funcionario3);
		
		/*
		 * Relationships OneToOne {Departamento} --> {Cargo}
		 */		
//		compras.getCargo().add(comprador);
//		compras.getCargo().add(aprovador);
//		compras.getCargo().add(gerente);
		
		/*
		 * Add Data into Table
		 */
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		funcionarios.add(funcionario3);
		
		return funcionarios;
	}
	
}
