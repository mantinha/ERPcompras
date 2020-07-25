package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.service.FuncionarioService;
import br.fsa.compras.service.RequisicaoDecoService;

/*
 * MAPEAMENTO DA URL
 * REQUEST
 * BUSCA RETORNAR PÁGINA PELO NOME
 */
@Controller
public class RequisicaoDecoController {
	/*
	 * INJEÇÃO DE DEPENDÊNCIA
	 */
	private final RequisicaoDecoService requisicaoDecoService;
	private final FuncionarioService funcionarioService;
	
	public RequisicaoDecoController(RequisicaoDecoService requisicaoDecoService,
			FuncionarioService funcionarioService) {
		this.requisicaoDecoService = requisicaoDecoService;
		this.funcionarioService = funcionarioService;
	}
	
	@RequestMapping({"/painelderequisicoes","/painelderequisicoes/","/painelderequisicoes/index"})
	public String getPainel(Model model) {

		model.addAttribute("funcionarios", funcionarioService.getFuncionarios());
		model.addAttribute("requisicoes", requisicaoDecoService.getRequisicaoDeco());
		
		return "painelderequisicoes/index";
	}
	
//	@PostMapping({"/gerarrequisicoes","/gerarrequisicoes/","/gerarrequisicoes/index"})
//	public String saveOrUpdate(@ModelAttribute RequisicaoDecoCommand command) {
//
//		RequisicaoDecoCommand savedCommand = requisicaoDecoService.saveRequisicaoDecoCommand(command);
//		
//		return "redirect:/gerarrequisicoes/" + savedCommand.getId() + "/show";
//	}
	
//	@RequestMapping({"","/","/index"})
//	public String showById(@PathVariable String id, Model model) {
//		
//		model.addAttribute("requisicao", requisicaoDeComprasService.findById(Long.valueOf(id)));
//		
//		return "painelderequisicoes/index";
//	}
}
