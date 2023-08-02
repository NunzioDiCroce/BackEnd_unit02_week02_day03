package com.example.GestionePrenotazioniWS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionePrenotazioniWS.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

}
