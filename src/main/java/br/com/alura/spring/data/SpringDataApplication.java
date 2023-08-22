package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	
	private Boolean system = true;
	
	public SpringDataApplication(
			CrudCargoService cargoService,
			CrudFuncionarioService funcionarioService,
			CrudUnidadeTrabalhoService unidadeTrabalhoService) {
		this.funcionarioService = funcionarioService;
		this.cargoService = cargoService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade de Trabalho");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1: {
				cargoService.inicial(scanner);
				break;
			}
			case 2: {
				funcionarioService.inicial(scanner);
				break;
			}
			case 3: {
				unidadeTrabalhoService.inicial(scanner);
				break;
			}
			default:
				system = false;
				break;
			}
			
		}
		
	}

}
