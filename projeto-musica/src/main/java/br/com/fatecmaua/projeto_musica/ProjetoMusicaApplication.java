package br.com.fatecmaua.projeto_musica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EntityScan
@ComponentScan
@SpringBootApplication
public class ProjetoMusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoMusicaApplication.class, args);
	}

}
