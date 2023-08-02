package com.example.GestionePrenotazioniWS.entities;

import com.example.GestionePrenotazioniWS.enums.TipoPostazione;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class PostazionePayload {

	protected String descrizione;

	@Enumerated(EnumType.STRING)
	protected TipoPostazione tipoPostazione;
	protected int numeroMassimoOccupanti;
	protected long edificioId;

}
