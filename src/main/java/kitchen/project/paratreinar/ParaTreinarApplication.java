package kitchen.project.paratreinar;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kitchen.project.paratreinar.domain.Cliente;
import kitchen.project.paratreinar.repositories.ClienteRepository;

@SpringBootApplication
public class ParaTreinarApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ParaTreinarApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Cliente cli1 = new Cliente(null, "Denis", "denismamoni@hotmail.com");
		Cliente cli2 = new Cliente(null, "Adrielly", "adriellyavelaar@gmail.com");
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		
		
		
	}

}
