package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.service.FuncionarioService;

@RequestMapping("funcionarios")
@Controller
public class FuncionarioController {
	private final FuncionarioService funcionarioService;
	
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("funcionarios", funcionarioService.getFuncionarios());
		
		return "funcionarios/index";
	}
}
