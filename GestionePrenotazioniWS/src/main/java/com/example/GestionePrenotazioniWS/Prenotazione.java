package com.example.GestionePrenotazioniWS;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "prenotazioni")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j

@Builder

public class Prenotazione {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	protected Utente utente;

	protected LocalDate dataPrenotazione;

	@ManyToOne
	protected Postazione postazione;

	public Prenotazione(Utente _utente, LocalDate _dataPrenotazione, Postazione _postazione) {
		this.utente = _utente;
		this.dataPrenotazione = _dataPrenotazione;
		this.postazione = _postazione;
	}

}
