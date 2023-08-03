package com.example.GestionePrenotazioniWS.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EdificioPayload {

	protected String nome;
	protected String indirizzo;
	protected String citta;
	// protected Set<Long> postazioneIds;

}
