package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.service.FuncionarioService;
import br.fsa.compras.service.RequisicaoDecoService;

@Controller
@RequestMapping("/requisicoes")
public class RequisicaoDecoController {
	
	private final RequisicaoDecoService requisicaoDecoService;
	private final FuncionarioService funcionarioService;
	
	public RequisicaoDecoController(RequisicaoDecoService requisicaoDecoService,
			FuncionarioService funcionarioService) {
		this.requisicaoDecoService = requisicaoDecoService;
		this.funcionarioService = funcionarioService;
	}
	
	@RequestMapping({"","/","/list"})
	public String list(Model model) {
		model.addAttribute("funcionarios", funcionarioService.getFuncionarios());
		model.addAttribute("requisicoes", requisicaoDecoService.getRequisicaoDeco());
		return "/requisicoes/list";
	}
	
}
