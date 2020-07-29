package br.fsa.compras.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.fsa.compras.model.Bloqueio;
import br.fsa.compras.model.Cargo;
import br.fsa.compras.model.Departamento;
import br.fsa.compras.model.Fornecedor;
import br.fsa.compras.model.Funcionario;
import br.fsa.compras.model.RequisicaoDeco;
import br.fsa.compras.repository.BloqueioRepository;
import br.fsa.compras.repository.CargoRepository;
import br.fsa.compras.repository.EnderecoRepository;
import br.fsa.compras.repository.FornecedorRepository;
import br.fsa.compras.repository.FuncionarioRepository;
import br.fsa.compras.repository.RequisicaoDecoRepository;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent>{
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final RequisicaoDecoRepository requisicaoDeComprasRepository;
	private final FornecedorRepository fornecedorRepository;
	private final BloqueioRepository bloqueioRepository;
	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public BootstrapData(CargoRepository cargoRepository, FuncionarioRepository funcionarioRepository,
			RequisicaoDecoRepository requisicaoDeComprasRepository, FornecedorRepository fornecedorRepository,
			BloqueioRepository bloqueioRepository, EnderecoRepository enderecoRepository) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
		this.requisicaoDeComprasRepository = requisicaoDeComprasRepository;
		this.fornecedorRepository = fornecedorRepository;
		this.bloqueioRepository = bloqueioRepository;
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		funcionarioRepository.saveAll(getFuncionarios());
		requisicaoDeComprasRepository.saveAll(getRequisicaoDeCompras());
		fornecedorRepository.saveAll(getFornecedores());
		
		System.out.println("Cargos registrados: " + cargoRepository.count());
		System.out.println("Funcionarios registrados " + funcionarioRepository.count());
		System.out.println("Requisições registradas " + requisicaoDeComprasRepository.count());
		System.out.println("Fornecedores registrados " + fornecedorRepository.count());
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
	
	private List<RequisicaoDeco> getRequisicaoDeCompras() {
		
		List<RequisicaoDeco> requisicaoDeCompras = new ArrayList<>(3);
		
		RequisicaoDeco req = new RequisicaoDeco();
		req.setCodigo(1);
		req.setMatricula(001);
		req.setMatriculaAprovador(013);
		req.setCentroDeCusto(12345);
		req.setCodigoMateriaPrima(1111);
		req.setQtdRequisitada(10);
		req.setData("23/07/2020");
		req.setDataPrevista("27/07/2020");
		
		RequisicaoDeco req2 = new RequisicaoDeco();
		req2.setCodigo(2);
		req2.setMatricula(002);
		req2.setMatriculaAprovador(013);
		req2.setCentroDeCusto(54321);
		req2.setCodigoMateriaPrima(2222);
		req2.setQtdRequisitada(20);
		req2.setData("25/07/2020");
		req2.setDataPrevista("27/07/2020");
		
		RequisicaoDeco req3 = new RequisicaoDeco();
		req3.setCodigo(3);
		req3.setMatricula(003);
		req3.setMatriculaAprovador(013);
		req3.setCentroDeCusto(12321);
		req3.setCodigoMateriaPrima(3333);
		req3.setQtdRequisitada(30);
		req3.setData("26/07/2020");
		req3.setDataPrevista("30/07/2020");
		
		requisicaoDeCompras.add(req);
		requisicaoDeCompras.add(req2);
		requisicaoDeCompras.add(req3);
		
		return requisicaoDeCompras;
	}
	
	private List<Fornecedor> getFornecedores() {
		
		Optional<Bloqueio> bloqueioOptional = bloqueioRepository.findByBloqueio("Nao");		
		if(!bloqueioOptional.isPresent()) {
			throw new RuntimeException("Bloqueio não encontrado!");
		}
		
		Optional<Bloqueio> dataOptional = bloqueioRepository.findByData("Sem data");		
		if(!dataOptional.isPresent()) {
			throw new RuntimeException("Data não encontrada!");
		}
		
		Optional<Bloqueio> motivoOptional = bloqueioRepository.findByMotivo("Sem motivo");		
		if(!motivoOptional.isPresent()) {
			throw new RuntimeException("Motivo não encontrado!");
		}
		
		List<Fornecedor> fornecedores = new ArrayList<>(2);
		
		Fornecedor fornecedor1 = new Fornecedor();
		
		fornecedor1.setCnpj("64.784.799/0001-37");
		fornecedor1.setData("01/07/2020");
//		fornecedor1.setEndereco(enderecoOptional.get());
		fornecedor1.setMatricula("001");
		fornecedor1.setNomeFantasia("Caloi");
		fornecedor1.setRazaoSocial("CALOI NORTE S.A.");
		fornecedor1.setSite("CALOI.COM.BR");		
		fornecedor1.setStatus("ATIVO");
		fornecedor1.setTelefone("4433-2211");
		
		Fornecedor fornecedor2 = new Fornecedor();
		
		fornecedor2.setCnpj("37.674.347/0001-20");
		fornecedor2.setData("02/07/2020");
//		fornecedor2.setEndereco(enderecoOptional.get());
		fornecedor2.setMatricula("002");
		fornecedor2.setNomeFantasia("Cannondale");
		fornecedor2.setRazaoSocial("Paulo Ricardo Pereira Mauricio Eireli ME");
		fornecedor2.setSite("CANNONDALE.COM.BR");		
		fornecedor2.setStatus("ATIVO");
		fornecedor2.setTelefone("5533-2277");
		
		fornecedores.add(fornecedor1);
		fornecedores.add(fornecedor2);
		
		return fornecedores;
	}
	
}
