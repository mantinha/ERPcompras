package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.service.CargoService;

@RequestMapping("cargos")
@Controller
public class CargoController {
	private final CargoService cargoService;
	
	public CargoController(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {

		model.addAttribute("cargos", cargoService.getCargos());
		
		return "cargos/index";
	}
}
