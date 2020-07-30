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

import br.fsa.compras.command.FuncionarioCommand;
import br.fsa.compras.exception.NotFoundException;
import br.fsa.compras.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	private static final String CADASTRO_FORM_URL = "/cadastro/form";
	private static final String ALTERA_FORM_URL = "/altera/form";
	private final FuncionarioService funcionarioService;
	
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@RequestMapping({"","/","/list"})
	public String listFuncionario(Model model) {
		model.addAttribute("funcionarios", funcionarioService.getFuncionarios());
		
		return "/funcionarios/list";
	}
	
	@GetMapping({"/cadastro",CADASTRO_FORM_URL})
	public String createFuncionario(Model model) {		
		model.addAttribute("funcionario", new FuncionarioCommand());
		
		return "/funcionarios" + CADASTRO_FORM_URL;
	}
	
	@PostMapping({"/cadastro",CADASTRO_FORM_URL,"/altera/{id}","/altera/{id}/form"})
	public String submitFuncionario(@Valid @ModelAttribute("funcionario") FuncionarioCommand command, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(objectError -> {
				System.out.println(objectError.toString());
			});
			
			return "/funcionarios" + CADASTRO_FORM_URL;
		}
		
		funcionarioService.saveFuncionarioCommand(command);
		
		return "redirect:/funcionarios";
	}
	
	@GetMapping({"/altera/{id}","/altera/{id}/form"})
	public String updateFuncionario(@PathVariable String id, Model model) {		
		model.addAttribute("funcionario", funcionarioService.findCommandById(Long.valueOf(id)));
		
		return "/funcionarios" + ALTERA_FORM_URL;
	}
	
	@GetMapping({"/exclui/{id}","/exclui/{id}/form"})
	public String deleteFuncionario(@PathVariable String id) {
		funcionarioService.deleteById(Long.valueOf(id));
		
		return "redirect:/funcionarios";
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
