package com.example.GestionePrenotazioniWS.entities;

import com.example.GestionePrenotazioniWS.enums.TipoPostazione;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class PostazionePayload {

	protected String descrizione;

	@Enumerated(EnumType.STRING)
	protected TipoPostazione tipoPostazione;

	protected int numeroMassimoOccupanti;

	@ManyToOne
	private Edificio edificio;

}
