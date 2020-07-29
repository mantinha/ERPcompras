package br.fsa.compras.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.fsa.compras.command.FornecedorCommand;
import br.fsa.compras.exception.NotFoundException;
import br.fsa.compras.service.FornecedorService;

@RequestMapping("/fornecedores")
@Controller
public class FornecedorController {
	
	private static final String CADASTRO_FORM_URL = "/cadastro/form";
	private static final String ALTERA_FORM_URL = "/altera/form";
	private final FornecedorService fornecedorService;
	
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@RequestMapping({"","/","/list"})
	public String listFornecedor(Model model) {
		model.addAttribute("fornecedores", fornecedorService.getFornecedor());
		
		return "/fornecedores/list";
	}
	
	@GetMapping({"/cadastro",CADASTRO_FORM_URL})
	public String createFornecedor(Model model) {		
		model.addAttribute("fornecedor", new FornecedorCommand());
		
		return "/fornecedores" + CADASTRO_FORM_URL;
	}
	
	@PostMapping({"/cadastro",CADASTRO_FORM_URL,"/altera/{id}","/altera/{id}/form"})
	public String submitFornecedor(@Valid @ModelAttribute("fornecedor") FornecedorCommand command, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(objectError -> {
				System.out.println(objectError.toString());
			});
			
			return "/fornecedores" + CADASTRO_FORM_URL;
		}
		
		fornecedorService.saveFornecedorCommand(command);
		
		return "redirect:/fornecedores";
	}
	
	@GetMapping({"/altera/{id}","/altera/{id}/form"})
	public String updateFornecedor(@PathVariable String id, Model model) {		
		model.addAttribute("fornecedor", fornecedorService.findCommandById(Long.valueOf(id)));
		
		return "/fornecedores" + ALTERA_FORM_URL;
	}
	
	@GetMapping({"/exclui/{id}","/exclui/{id}/form"})
	public String deleteFornecedor(@PathVariable String id) {
		fornecedorService.deleteById(Long.valueOf(id));
		
		return "redirect:/fornecedores";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        System.out.println("Handling not found exception");
        System.out.println("---" + exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}
