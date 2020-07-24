package br.fsa.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.fsa.compras.controller.IndexController;

@SpringBootApplication
public class ErPcomprasApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ErPcomprasApplication.class, args);
		
		IndexController indexController = (IndexController) context.getBean("indexController");
		
		String inicio = indexController.getIndexPage();
		
		System.out.println("------" + inicio);
	}

}
