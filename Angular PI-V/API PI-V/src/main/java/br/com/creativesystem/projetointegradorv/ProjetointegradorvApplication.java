package br.com.creativesystem.projetointegradorv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjetointegradorvApplication.
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "PI-V",
    version = "1.0",
    description = "API RESTful do Projeto Integrador V",
    license = @License(name = "Open Source")
))
public class ProjetointegradorvApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjetointegradorvApplication.class, args);
	}

}
