package br.fsa.compras.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.fsa.compras.command.RequisicaoDecoCommand;
import br.fsa.compras.exception.NotFoundException;
import br.fsa.compras.service.FuncionarioService;
import br.fsa.compras.service.RequisicaoDecoService;

@Controller
@RequestMapping("/requisicoes")
public class RequisicaoDecoController {
	
	private static final String REQUISICAO_FORM_URL = "/enviar/form";
	private final RequisicaoDecoService requisicaoDecoService;
	private final FuncionarioService funcionarioService;
	
	public RequisicaoDecoController(RequisicaoDecoService requisicaoDecoService,
			FuncionarioService funcionarioService) {
		this.requisicaoDecoService = requisicaoDecoService;
		this.funcionarioService = funcionarioService;
	}
	
	@RequestMapping({"","/","/list"})
	public String listRequisicao(Model model) {
		model.addAttribute("funcionarios", funcionarioService.getFuncionarios());
		model.addAttribute("requisicoes", requisicaoDecoService.getRequisicaoDeco());
		
		return "/requisicoes/list";
	}
	
	@GetMapping({"/enviar",REQUISICAO_FORM_URL})
	public String createRequisicao(Model model) {		
		model.addAttribute("requisicao", new RequisicaoDecoCommand());
		
		return "/requisicoes" + REQUISICAO_FORM_URL;
	}
	
	@PostMapping({"/enviar",REQUISICAO_FORM_URL})
	public String submitRequisicao(@Valid @ModelAttribute("requisicao") RequisicaoDecoCommand command, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(objectError -> {
				System.out.println(objectError.toString());
			});
			
			return "/requisicoes" + REQUISICAO_FORM_URL;
		}
		
		requisicaoDecoService.saveRequisicaoDecoCommand(command);
		
		return "redirect:/requisicoes";
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
