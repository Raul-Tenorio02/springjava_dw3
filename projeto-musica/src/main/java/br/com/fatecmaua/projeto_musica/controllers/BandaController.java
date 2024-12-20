package br.com.fatecmaua.projeto_musica.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecmaua.projeto_musica.models.Banda;
import br.com.fatecmaua.projeto_musica.repositories.BandaRepository;
import br.com.fatecmaua.projeto_musica.repositories.MusicaRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class BandaController {

	@Autowired
	private BandaRepository repBanda;
	@Autowired
	private MusicaRepository repMusica;

	@Operation(summary = "Buscar todas as bandas",
			description = "Este endpoint realiza "
					+ "a busca de todas as "
					+ "bandas presentes na base de dados",
					tags = "Retorno de Informações")
	@GetMapping("/bandas/todas")
	public List<Banda> buscarTodasBandas() {
		return repBanda.findAll();
	}
	
	@Operation(summary = "Buscar todas as bandas com "
			+ "um determinado número de caracteres",
			description = "Este endpoint realiza "
					+ "a busca de todas as "
					+ "bandas presentes na base de dados"
					+ " com um determinado número de caracteres",
					tags = "Retorno de Informações")
	@GetMapping("/bandas/min_caracteres/{var}")
	public List<Banda> 
	retornaBandasMinCaracteres(@PathVariable int var){
		List<Banda> todas = repBanda.findAll();
		List<Banda> resultado = new ArrayList<Banda>();
		
		for(Banda banda : todas) {
			if(banda.getNome().length() >= var) {
				resultado.add(banda);
			}
		}
		return resultado;
	}

	@Operation(summary = "Buscar todas as bandas do Brasil",
			description = "Este endpoint realiza "
					+ "a busca de todas as "
					+ "bandas do Brasil presentes na base de dados ",
					tags = "Retorno de Informações")
	@GetMapping("/bandas/todas/brasil")
	public List<Banda> buscarTodasBrasil() {

		List<Banda> todas = repBanda.findAll();
		List<Banda> todas_brasil = new ArrayList<Banda>();

		for (Banda banda : todas) {
			if (banda.getPais_origem().equals("Brasil")) {
				todas_brasil.add(banda);
			}
		}

		return todas_brasil;

	}

	@Operation(summary = "Buscar as bandas por ID",
			description = "Este endpoint realiza "
					+ "a busca "
					+ "bandas presentes na base de dados por ID",
					tags = "Retorno de Informações")
	@GetMapping("/bandas/{id}")
	public Banda buscarBandaPorID(@PathVariable Long id) {
		return repBanda.findById(id).get();
	}

	@Operation(summary = "Buscar todas as bandas com "
			+ "um determinado número de albuns",
			description = "Este endpoint realiza "
					+ "a busca de todas as "
					+ "bandas (com um determinado "
					+ "número de albuns) presentes na base de dados",
					tags = "Retorno de Informações")
	@GetMapping("/bandas/qtdalbuns/{var}")
	public List<Banda> buscarBandasMinQtdAlbuns(@PathVariable Integer var) {

		List<Banda> todas = repBanda.findAll();
		List<Banda> resultado = new ArrayList<Banda>();

		for (Banda banda : todas) {
			if (banda.getQtd_albuns() >= var) {
				resultado.add(banda);
			}
		}

		return resultado;

	}

	@Operation(summary = "Remover bandas por ID",
			description = "Este endpoint realiza "
					+ "a remoção de "
					+ "bandas presentes na base de dados por ID",
					tags = "Remoção de Informações")
	@DeleteMapping("/bandas/{id}")
	public void removerBandaPorID(@PathVariable Long id) {
		Optional<Banda> op = repBanda.findById(id);
		if(op.isPresent())
			repBanda.deleteById(id);
	}
	
	@Operation(summary = "Inserir uma nova banda",
			description = "Este endpoint realiza "
					+ "a inserção de "
					+ "bandas na base de dados",
					tags = "Inserção de Informações")
	@PostMapping("/bandas/inserir")
	public void inserirBanda(@RequestBody Banda banda) {
		repBanda.save(banda);
	}
	
	@Operation(summary = "Atualizar uma banda",
			description = "Este endpoint realiza "
					+ "a atualização de uma "
					+ "banda presente na base de dados",
					tags = "Atualização de Informações")
	@PutMapping("/bandas/atualizar/{id}")
	public void 
	atualizarBanda(@PathVariable Long id, 
			@RequestBody Banda banda) {
		
		Optional<Banda> op = repBanda.findById(id);
		
		if(op.isPresent()) {
			Banda banda_atualizar = op.get(); 
			banda_atualizar.setNome(banda.getNome());
			banda_atualizar.setPais_origem(banda.getPais_origem());
			banda_atualizar.setData_fundacao(banda.getData_fundacao());
			banda_atualizar.setQtd_albuns(banda.getQtd_albuns());
			repBanda.save(banda_atualizar);
		}
		
		
	}
	
	
	
	
	
	
	
	

}
