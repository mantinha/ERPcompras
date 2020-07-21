package br.fsa.compras.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.fsa.compras.model.Cargo;
import br.fsa.compras.repository.CargoRepository;

@Service
public class CargoServiceImpl implements CargoService{
	
	private final CargoRepository cargoRepository;
	
	public CargoServiceImpl(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@Override
	public Set<Cargo> getCargos() {
		
		Set<Cargo> cargoSet = new HashSet<>();
		cargoRepository.findAll().iterator().forEachRemaining(cargoSet::add);
		return cargoSet;
	}

}
