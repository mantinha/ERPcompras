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

import br.fsa.compras.command.EnderecoCommand;
import br.fsa.compras.exception.NotFoundException;
import br.fsa.compras.service.EnderecoService;

@Controller
@RequestMapping("/fornecedores/endereco")
public class EnderecoController {
	
	private static final String ALTERA_FORM_URL = "/endereco/{id}/form";	
	private final EnderecoService enderecoService;
	
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	@PostMapping({"/{id}","/{id}/form"})
	public String submitEndereco(@Valid @ModelAttribute("endereco") EnderecoCommand command, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(objectError -> {
				System.out.println(objectError.toString());
			});
			
			return "/fornecedores" + ALTERA_FORM_URL;
		}
		
		enderecoService.saveEnderecoCommand(command);
		
		return "redirect:/fornecedores";
	}
	
	@GetMapping({"/{id}","/{id}/form"})
	public String updateEndereco(@PathVariable String id, Model model) {		
		model.addAttribute("endereco", enderecoService.findCommandById(Long.valueOf(id)));
		
		return "/fornecedores" + ALTERA_FORM_URL;
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
