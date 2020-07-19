package br.fsa.compras.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.fsa.compras.model.Cargo;
import br.fsa.compras.model.Departamento;
import br.fsa.compras.repository.CargoRepository;
import br.fsa.compras.repository.DepartamentoRepository;

@Component
public class BootstrapData implements CommandLineRunner{

	private final DepartamentoRepository departamentoRepository;
	private final CargoRepository cargoRepository;
	
	public BootstrapData(DepartamentoRepository departamentoRepository, CargoRepository cargoRepository) {
		super();
		this.departamentoRepository = departamentoRepository;
		this.cargoRepository = cargoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Departamento departamento = new Departamento("Compras");
		Cargo cargo = new Cargo("Aprovador");
		
		/*
		 * Save data
		 */
		cargoRepository.save(cargo);
		departamentoRepository.save(departamento);
		
		/*
		 * Relationships ManyToOne and OneToMany
		 */
		cargo.setDepartamento(departamento);
		departamento.getCargo().add(cargo);
		
		/*
		 * Save relationship data
		 */
		cargoRepository.save(cargo);
		
		System.out.println("Numero de Cargos: " + cargoRepository.count());
		System.out.println("Numero de Departamentos: " + departamentoRepository.count());
		
	}
	
	

}
