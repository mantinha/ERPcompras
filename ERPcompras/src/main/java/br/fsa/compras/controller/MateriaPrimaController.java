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

import br.fsa.compras.command.MateriaPrimaCommand;
import br.fsa.compras.exception.NotFoundException;
import br.fsa.compras.service.MateriaPrimaService;

@Controller
@RequestMapping("/insumos")
public class MateriaPrimaController {
	
	private static final String CADASTRO_FORM_URL = "/cadastro/form";
	private static final String ALTERA_FORM_URL = "/altera/form";
	private final MateriaPrimaService materiaPrimaService;
	
	public MateriaPrimaController(MateriaPrimaService materiaPrimaService) {
		this.materiaPrimaService = materiaPrimaService;
	}

	@RequestMapping({"","/","/list"})
	public String listMateriaPrima(Model model) {
		model.addAttribute("insumos", materiaPrimaService.getMateriaPrima());
		
		return "/insumos/list";
	}
	
	@GetMapping({"/cadastro",CADASTRO_FORM_URL})
	public String createMateriaPrima(Model model) {		
		model.addAttribute("insumo", new MateriaPrimaCommand());
		
		return "/insumos" + CADASTRO_FORM_URL;
	}
	
	@PostMapping({"/cadastro",CADASTRO_FORM_URL,"/altera/{id}","/altera/{id}/form"})
	public String submitMateriaPrima(@Valid @ModelAttribute("insumo") MateriaPrimaCommand command, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(objectError -> {
				System.out.println(objectError.toString());
			});
			
			return "/insumos" + CADASTRO_FORM_URL;
		}
		
		materiaPrimaService.saveMateriaPrimaCommand(command);
		
		return "redirect:/insumos";
	}
	
	@GetMapping({"/altera/{id}","/altera/{id}/form"})
	public String updateMateriaPrima(@PathVariable String id, Model model) {		
		model.addAttribute("insumo", materiaPrimaService.findCommandById(Long.valueOf(id)));
		
		return "/insumos" + ALTERA_FORM_URL;
	}
	
	@GetMapping({"/exclui/{id}","/exclui/{id}/form"})
	public String deleteMateriaPrima(@PathVariable String id) {
		materiaPrimaService.deleteById(Long.valueOf(id));
		
		return "redirect:/insumos";
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
