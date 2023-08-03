package com.example.GestionePrenotazioniWS.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrenotazionePayload {

	protected long utenteId;
	protected LocalDate dataPrenotazione;
	protected long postazioneId;

}
