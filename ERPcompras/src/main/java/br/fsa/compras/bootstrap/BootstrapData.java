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
		
//		departamentoRepository.saveAll(getDepartamentos());
		funcionarioRepository.saveAll(getFuncionarios());
		
		System.out.println("Cargos registrados: " + cargoRepository.count());
		System.out.println("Departamentos registrados: " + departamentoRepository.count());
		System.out.println("Funcionarios registrados " + funcionarioRepository.count());
	}
	
	public List<Departamento> allDepartamentos() {
		
		List<Departamento> departamentos = new ArrayList<>(2);
		
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
		
		departamentos.add(compras);
		departamentos.add(financeiro);
		
		return departamentos;
	}
	
	public List<Cargo> allCargos() {
		
		List<Cargo> cargos = new ArrayList<>(3);
		
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
		
		cargos.add(aprovador);
		cargos.add(comprador);
		cargos.add(gerente);
		
		return cargos;
	}
	
//	private List<Departamento> getDepartamentos() {
//		
//		List<Departamento> departamentos = new ArrayList<>(2);
//		
//		/*
//		 * Relationships ManyToMany {Departamento} --> {Cargo}
//		 */		
//		allDepartamentos().get(0).getCargo().add(allCargos().get(0));
//		allDepartamentos().get(0).getCargo().add(allCargos().get(1));
//		allDepartamentos().get(0).getCargo().add(allCargos().get(2));			
//		allDepartamentos().get(1).getCargo().add(allCargos().get(0));
//		allDepartamentos().get(1).getCargo().add(allCargos().get(1));
//		allDepartamentos().get(1).getCargo().add(allCargos().get(2));
//		
//		departamentos.add(allDepartamentos().get(0));
//		departamentos.add(allDepartamentos().get(1));
//		
//		return departamentos;
//	}
	
	/*
	 * Feed Table Funcionario
	 */
	private List<Funcionario> getFuncionarios() {
		
		List<Funcionario> funcionarios = new ArrayList<>(5);
		
		Funcionario adriano = new Funcionario();
		adriano.setNome("Adriano Macedo Santana");
		adriano.setEmail("adriano.santana@ads.fsa.br");
		adriano.setCargo(allCargos().get(2));
		adriano.setDepartamento(allDepartamentos().get(0));
		
		Funcionario erick = new Funcionario();
		erick.setNome("Erick Ticianeli Krywko");
		erick.setEmail("erick.krywko@ads.fsa.br");
		erick.setCargo(allCargos().get(0));		
		erick.setDepartamento(allDepartamentos().get(0));		
		
		Funcionario pedro = new Funcionario();
		pedro.setNome("Pedro Ivo Ramos de Oliveira");
		pedro.setEmail("pedro.oliveira@ads.fsa.br");
		pedro.setCargo(allCargos().get(1));		
		pedro.setDepartamento(allDepartamentos().get(0));
		
		Funcionario lucas = new Funcionario();
		lucas.setNome("Lucas Farias Piasentin");
		lucas.setEmail("lucas.piasentin@ads.fsa.br");
		lucas.setCargo(allCargos().get(1));		
		lucas.setDepartamento(allDepartamentos().get(1));
		
		Funcionario jaqueline = new Funcionario();
		jaqueline.setNome("Jaqueline da Cruz Viel");
		jaqueline.setEmail("jaqueline.viel@ads.fsa.br");
		jaqueline.setCargo(allCargos().get(1));		
		jaqueline.setDepartamento(allDepartamentos().get(1));
		
		Funcionario carlos = new Funcionario();
		carlos.setNome("Carlos Henrique de Oliveira");
		carlos.setEmail("carlos.oliveira@ads.fsa.br");
		carlos.setCargo(allCargos().get(1));
		carlos.setDepartamento(allDepartamentos().get(1));
		
		funcionarios.add(adriano);
		funcionarios.add(erick);
		funcionarios.add(pedro);
		funcionarios.add(lucas);
		funcionarios.add(jaqueline);
		funcionarios.add(carlos);
		
		return funcionarios;
	}
	
}
