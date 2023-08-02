package com.example.GestionePrenotazioniWS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.GestionePrenotazioniWS.entities.Postazione;
import com.example.GestionePrenotazioniWS.enums.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	@Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipoPostazione AND p.edificio.citta = :citta")
	List<Postazione> cercaPostazionePerTipoAndCitta(@Param("tipoPostazione") TipoPostazione tipoPostazione,
			@Param("citta") String citta);

}
