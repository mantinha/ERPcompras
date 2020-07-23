package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.model.RequisicaoDeCompras;
import br.fsa.compras.service.RequisicaoDeComprasService;

@RequestMapping("requisicoes")
@Controller
public class RequisicaoDeComprasController {

	private final RequisicaoDeComprasService requisicaoDeComprasService;

	public RequisicaoDeComprasController(RequisicaoDeComprasService requisicaoDeComprasService) {
		this.requisicaoDeComprasService = requisicaoDeComprasService;
	}
	
	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("requisicoes", requisicaoDeComprasService.getRequisicaoDeCompras());
		
		return "requisicoes/index";
	}
	
	@PostMapping({"","/","/index"})
	public String postIndexPage(@ModelAttribute RequisicaoDeCompras requisicaoDeCompras) {		
		
		return null;
	}
	
}
