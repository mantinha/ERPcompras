package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.service.CargoService;
import br.fsa.compras.service.DepartamentoService;
import br.fsa.compras.service.FuncionarioService;

@Controller
public class IndexController {
	
	private final FuncionarioService funcionarioService;
	private final CargoService cargoService;
	private final DepartamentoService departamentoService;

	public IndexController(FuncionarioService funcionarioService, CargoService cargoService,
			DepartamentoService departamentoService) {
		this.funcionarioService = funcionarioService;
		this.cargoService = cargoService;
		this.departamentoService = departamentoService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("funcionarios", funcionarioService.getFuncionarios());
		model.addAttribute("cargos", cargoService.getCargos());
		model.addAttribute("departamentos", departamentoService.getDepartamentos());
		
		return "index";
	}
}
