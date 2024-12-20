package br.com.fatecmaua.projeto_musica.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "musica")
public class Musica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_banda")
	private Banda banda;
	private String genero;
	private Double duracao;
	private Date data_lancamento;
	private String nome;
	private String idioma;

	public Musica(Long id, Banda banda, String genero, Double duracao, Date data_lancamento, String nome,
			String idioma) {
		this.id = id;
		this.banda = banda;
		this.genero = genero;
		this.duracao = duracao;
		this.data_lancamento = data_lancamento;
		this.nome = nome;
		this.idioma = idioma;
	}

	public Musica() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public Date getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
