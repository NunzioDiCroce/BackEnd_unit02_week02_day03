package com.example.GestionePrenotazioniWS.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionePrenotazioniWS.entities.Postazione;
import com.example.GestionePrenotazioniWS.entities.Prenotazione;
import com.example.GestionePrenotazioniWS.entities.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	Prenotazione findByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);

	// - - - - - - - - - - - - - - - CUSTOM QUERY
	Prenotazione findByDataPrenotazioneAndUtente(LocalDate dataPrenotazione, Utente utente);

}
