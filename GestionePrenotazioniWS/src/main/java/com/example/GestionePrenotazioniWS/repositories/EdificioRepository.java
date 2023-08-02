package com.example.GestionePrenotazioniWS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionePrenotazioniWS.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
