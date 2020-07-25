package br.fsa.compras.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * MAPEAMENTO DA URL
 * REQUEST
 * BUSCA RETORNAR PÁGINA PELO NOME
 */
@Controller
public class IndexController {

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage() {
		
		return "index";
	}	
	
}