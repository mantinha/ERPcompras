package br.fsa.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErPcomprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErPcomprasApplication.class, args);
//		ApplicationContext context = SpringApplication.run(ErPcomprasApplication.class, args);
//		
//		IndexController indexController = (IndexController) context.getBean("indexController");
//		
//		String inicio = indexController.getIndexPage();
//		
//		System.out.println("------" + inicio);
	}

}
