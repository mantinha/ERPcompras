package br.fsa.compras.bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.fsa.compras.model.Cargo;
import br.fsa.compras.model.Departamento;
import br.fsa.compras.model.Funcionario;
import br.fsa.compras.model.RequisicaoDeCompras;
import br.fsa.compras.repository.CargoRepository;
import br.fsa.compras.repository.FuncionarioRepository;
import br.fsa.compras.repository.RequisicaoDeComprasRepository;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent>{
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final RequisicaoDeComprasRepository requisicaoDeComprasRepository;	

	public BootstrapData(CargoRepository cargoRepository, FuncionarioRepository funcionarioRepository,
			RequisicaoDeComprasRepository requisicaoDeComprasRepository) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
		this.requisicaoDeComprasRepository = requisicaoDeComprasRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		funcionarioRepository.saveAll(getFuncionarios());
		requisicaoDeComprasRepository.saveAll(getRequisicaoDeCompras());
		
		System.out.println("Cargos registrados: " + cargoRepository.count());
		System.out.println("Funcionarios registrados " + funcionarioRepository.count());
		System.out.println("Requisições registradas " + requisicaoDeComprasRepository.count());
	}

	private List<Funcionario> getFuncionarios() {
		
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
		
		List<Funcionario> funcionarios = new ArrayList<>(5);
		
		Funcionario adriano = new Funcionario();
		adriano.setNome("Adriano Macedo Santana");
		adriano.setEmail("adriano.santana@ads.fsa.br");
		adriano.setCargo(gerenteCargoOptional.get());		
		adriano.setDepartamento(Departamento.COMPRAS);
		
		Funcionario erick = new Funcionario();
		erick.setNome("Erick Ticianeli Krywko");
		erick.setEmail("erick.krywko@ads.fsa.br");
		erick.setCargo(aprovadorCargoOptional.get());				
		erick.setDepartamento(Departamento.COMPRAS);
		
		Funcionario pedro = new Funcionario();
		pedro.setNome("Pedro Ivo Ramos de Oliveira");
		pedro.setEmail("pedro.oliveira@ads.fsa.br");
		pedro.setCargo(compradorCargoOptional.get());		
		pedro.setDepartamento(Departamento.COMPRAS);
		
		Funcionario lucas = new Funcionario();
		lucas.setNome("Lucas Farias Piasentin");
		lucas.setEmail("lucas.piasentin@ads.fsa.br");
		lucas.setCargo(compradorCargoOptional.get());		
		lucas.setDepartamento(Departamento.COMPRAS);
		
		Funcionario jaqueline = new Funcionario();
		jaqueline.setNome("Jaqueline da Cruz Viel");
		jaqueline.setEmail("jaqueline.viel@ads.fsa.br");
		jaqueline.setCargo(compradorCargoOptional.get());		
		jaqueline.setDepartamento(Departamento.FINANCEIRO);
		
		Funcionario carlos = new Funcionario();
		carlos.setNome("Carlos Henrique de Oliveira");
		carlos.setEmail("carlos.oliveira@ads.fsa.br");
		carlos.setCargo(compradorCargoOptional.get());
		carlos.setDepartamento(Departamento.FINANCEIRO);
		
		funcionarios.add(adriano);
		funcionarios.add(erick);
		funcionarios.add(pedro);
		funcionarios.add(lucas);
		funcionarios.add(jaqueline);
		funcionarios.add(carlos);
		
		return funcionarios;
	}
	
	private List<RequisicaoDeCompras> getRequisicaoDeCompras() {
		
		List<RequisicaoDeCompras> requisicaoDeCompras = new ArrayList<>(1);
		
		RequisicaoDeCompras req = new RequisicaoDeCompras();
		req.setCodigo(1);
		req.setMatricula(12);
		req.setMatriculaAprovador(123);
		req.setCentroDeCusto(1234);
		req.setCodigoMateriaPrima(4321);
		req.setQtdRequisitada(5);
		req.setData(LocalDate.now());
		req.setDataPrevista(LocalDate.now());
		
		requisicaoDeCompras.add(req);
		
		return requisicaoDeCompras;
	}
	
}
