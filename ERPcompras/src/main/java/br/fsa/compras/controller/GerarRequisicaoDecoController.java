package br.fsa.compras.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.fsa.compras.command.RequisicaoDecoCommand;
import br.fsa.compras.exception.NotFoundException;
import br.fsa.compras.service.RequisicaoDecoService;

@Controller
public class GerarRequisicaoDecoController {
	
	private static final String RECIPE_RECIPEFORM_URL = "gerarrequisicoes/gerarrequisicoesform";
	/*
	 * INJEÇÃO DE DEPENDÊNCIA
	 */
	private final RequisicaoDecoService requisicaoDecoService;
	
	public GerarRequisicaoDecoController(RequisicaoDecoService requisicaoDecoService) {
		this.requisicaoDecoService = requisicaoDecoService;
	}

	@GetMapping("/gerarrequisicoes/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", requisicaoDecoService.findById(Long.valueOf(id)));

        return "gerarrequisicoes/show";
    }
	
	@GetMapping("gerarrequisicoes/new")
    public String newGerarRequisicao(Model model){
        model.addAttribute("requisicao", new RequisicaoDecoCommand());

        return "gerarrequisicoes/gerarrequisicoesform";
    }
	
	@GetMapping("recipe/{id}/update")
    public String updateRequisicao(@PathVariable String id, Model model){
        model.addAttribute("recipe", requisicaoDecoService.findCommandById(Long.valueOf(id)));
        return RECIPE_RECIPEFORM_URL;
    }
	/*
	 * NECESSARIO
	 */
	@RequestMapping({"/gerarrequisicoes","/gerarrequisicoes/","/gerarrequisicoes/index"})
	public String getRequisicaoDecoPage(Model model) {

		model.addAttribute("requisicoes", requisicaoDecoService.getRequisicaoDeco());
		
		return "gerarrequisicoes/index";
	}
	
	@PostMapping({"/gerarrequisicoes","/gerarrequisicoes/","/gerarrequisicoes/index"})
	public String saveOrUpdate(@ModelAttribute RequisicaoDecoCommand command) {

		RequisicaoDecoCommand savedCommand = requisicaoDecoService.saveRequisicaoDecoCommand(command);
		
		return "redirect:/gerarrequisicoes/" + savedCommand.getId() + "/show";
	}
	/***********************************************************************************/
	@GetMapping("gerarrequisicoes/{id}/delete")
    public String deleteById(@PathVariable String id){

        System.out.println("Deleting id: " + id);

        requisicaoDecoService.deleteById(Long.valueOf(id));
        return "redirect:/";
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
