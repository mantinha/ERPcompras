package br.fsa.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.model.RequisicaoDeCompras;
import br.fsa.compras.service.RequisicaoDeComprasService;

@RequestMapping("requisicoes")
@Controller
public class RequisicaoDeComprasController {
	
	private final RequisicaoDeComprasService requisicaoDeComprasService;
	
	@Autowired
	public RequisicaoDeComprasController(RequisicaoDeComprasService requisicaoDeComprasService) {
		this.requisicaoDeComprasService = requisicaoDeComprasService;
	}
	
	@GetMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("requisicoes", requisicaoDeComprasService.getRequisicaoDeCompras());
		
		return "requisicoes/index";
	}
	
	@PostMapping({"","/","/index"})
	public String postIndexPage(@ModelAttribute RequisicaoDeCompras requisicaoDeCompras) {
		
		requisicaoDeComprasService.postRequisicaoDeCompras();
		
		return "redirect:/requisicoes/index";
	}
	
}
