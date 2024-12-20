package br.com.fatecmaua.projeto_musica.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigSwagger {
	@Bean
	public OpenAPI customAPI() {
		return new OpenAPI().info(
         new Info().title("Projeto Música")
         .description("Este é um projeto sobre músicas "
         		+ "e artistas musicais").version("1.0.0"));
	}

}
