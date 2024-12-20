package br.com.fatecmaua.projeto_musica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatecmaua.projeto_musica.models.Banda;

@Repository
public interface BandaRepository extends JpaRepository<Banda, Long> {

}
