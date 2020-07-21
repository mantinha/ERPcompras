package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fsa.compras.service.DepartamentoService;

@RequestMapping("departamentos")
@Controller
public class DepartamentoController {
	private final DepartamentoService departamentoService;
	
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("departamentos", departamentoService.getDepartamentos());
		
		return "departamentos/index";
	}
}
