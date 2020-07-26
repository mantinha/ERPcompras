package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fornecedores")
@Controller
public class FornecedorController {
	
	@RequestMapping({"","/","/list"})
	public String list() {

		return "/fornecedores/list";
	}

}
