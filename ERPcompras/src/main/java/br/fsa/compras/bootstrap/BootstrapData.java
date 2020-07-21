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
//		departamentoRepository.saveAll(getDepartamentos());
		
		System.out.println("Cargos registrados: " + cargoRepository.count());
		System.out.println("Departamentos registrados: " + departamentoRepository.count());
		System.out.println("Funcionarios registrados " + funcionarioRepository.count());
	}
	
//	private List<Departamento> getDepartamentos() {
//		
//		List<Departamento> departamentos = new ArrayList<>(2);
//		
//		/*
//		 * Get Data Cargo
//		 */
//		Optional<Cargo> aprovadorCargoOptional = cargoRepository.findByNome("Aprovador");		
//		if(!aprovadorCargoOptional.isPresent()) {
//			throw new RuntimeException("Cargo não encontrado!");
//		}
//		
//		Optional<Cargo> compradorCargoOptional = cargoRepository.findByNome("Comprador");		
//		if(!compradorCargoOptional.isPresent()) {
//			throw new RuntimeException("Cargo não encontrado!");
//		}
//		
//		Optional<Cargo> gerenteCargoOptional = cargoRepository.findByNome("Gerente");		
//		if(!gerenteCargoOptional.isPresent()) {
//			throw new RuntimeException("Cargo não encontrado!");
//		}
//		
//		Cargo aprovador = aprovadorCargoOptional.get();
//		Cargo comprador = compradorCargoOptional.get();
//		Cargo gerente = gerenteCargoOptional.get();
//		
//		/*
//		 * Get Data Departamento
//		 */
//		Optional<Departamento> comprasDepartamentoOptional = departamentoRepository.findByNome("Compras");
//		if(!comprasDepartamentoOptional.isPresent()) {
//			throw new RuntimeException("Departamento não encontrado!");
//		}
//		
//		Optional<Departamento> financeiroDepartamentoOptional = departamentoRepository.findByNome("Financeiro");
//		if(!financeiroDepartamentoOptional.isPresent()) {
//			throw new RuntimeException("Departamento não encontrado!");
//		}
//		
//		Departamento compras = comprasDepartamentoOptional.get();
//		Departamento financeiro = financeiroDepartamentoOptional.get();
//		
//		/*
//		 * Relationships ManyToMany {Departamento} --> {Cargo}
//		 */
//		
//		compras.getCargo().add(comprador);
//		compras.getCargo().add(aprovador);
//		compras.getCargo().add(gerente);
//		
//		financeiro.getCargo().add(comprador);
//		financeiro.getCargo().add(aprovador);
//		financeiro.getCargo().add(gerente);
//		
//		/*
//		 * Add Data into Table
//		 */
//		departamentos.add(compras);
//		departamentos.add(financeiro);
//		
//		return departamentos;
//	}
	
	private List<Funcionario> getFuncionarios() {
		
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
		 * Input Data Funcionario
		 */
		List<Funcionario> funcionarios = new ArrayList<>(5);
		
		/*
		 * Input Data
		 * Relationships OneToOne {Cargo} --> {Funcionario}
		 * Relationships OneToOne {Departamento} --> {Funcionario}
		 * Relationships ManyToMany {Departamento} --> {Cargo}
		 */
		Funcionario adriano = new Funcionario();
		adriano.setNome("Adriano Macedo Santana");
		adriano.setEmail("adriano.santana@ads.fsa.br");
		adriano.setCargo(gerente);
		gerente.setFuncionario(adriano);
		adriano.setDepartamento(compras);
		compras.setFuncionario(adriano);		
		compras.getCargo().add(gerente);
		gerente.getDepartamento().add(compras);		
		departamentoRepository.save(compras);
		cargoRepository.save(gerente);
		
		Funcionario erick = new Funcionario();
		erick.setNome("Erick Ticianeli Krywko");
		erick.setEmail("erick.krywko@ads.fsa.br");
		erick.setCargo(aprovador);
		aprovador.setFuncionario(erick);
		erick.setDepartamento(compras);
		compras.setFuncionario(erick);
		compras.getCargo().add(aprovador);
		aprovador.getDepartamento().add(compras);
		
		Funcionario pedro = new Funcionario();
		pedro.setNome("Pedro Ivo Ramos de Oliveira");
		pedro.setEmail("pedro.oliveira@ads.fsa.br");
		pedro.setCargo(comprador);
		comprador.setFuncionario(pedro);
		pedro.setDepartamento(compras);
		compras.setFuncionario(pedro);
		compras.getCargo().add(comprador);
		comprador.getDepartamento().add(compras);
		
		Funcionario lucas = new Funcionario();
		lucas.setNome("Lucas Farias Piasentin");
		lucas.setEmail("lucas.piasentin@ads.fsa.br");
		lucas.setCargo(comprador);
		comprador.setFuncionario(lucas);
		lucas.setDepartamento(financeiro);		
		financeiro.setFuncionario(lucas);
		financeiro.getCargo().add(comprador);
		comprador.getDepartamento().add(financeiro);
		
		Funcionario jaqueline = new Funcionario();
		jaqueline.setNome("Jaqueline da Cruz Viel");
		jaqueline.setEmail("jaqueline.viel@ads.fsa.br");
		jaqueline.setCargo(comprador);
		comprador.setFuncionario(jaqueline);
		jaqueline.setDepartamento(financeiro);
		financeiro.setFuncionario(jaqueline);
		financeiro.getCargo().add(comprador);
		comprador.getDepartamento().add(financeiro);
		
		Funcionario carlos = new Funcionario();
		carlos.setNome("Carlos Henrique de Oliveira");
		carlos.setEmail("carlos.oliveira@ads.fsa.br");
		carlos.setCargo(comprador);
		comprador.setFuncionario(carlos);
		carlos.setDepartamento(financeiro);
		financeiro.setFuncionario(carlos);
		financeiro.getCargo().add(comprador);
		comprador.getDepartamento().add(financeiro);
		
		/*
		 * Add Data into Table
		 */
		funcionarios.add(adriano);
		funcionarios.add(erick);
		funcionarios.add(pedro);
		funcionarios.add(lucas);
		funcionarios.add(jaqueline);
		funcionarios.add(carlos);
		
		return funcionarios;
	}
	
}
