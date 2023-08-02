package com.example.GestionePrenotazioniWS.entities;

import java.util.Set;

import com.example.GestionePrenotazioniWS.enums.TipoPostazione;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "postazioni")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j

@Builder

public class Postazione {

	@Id
	@GeneratedValue
	private long id;

	protected String descrizione;

	@Enumerated(EnumType.STRING)
	protected TipoPostazione tipoPostazione;

	protected int numeroMassimoOccupanti;

	@ManyToOne
	private Edificio edificio;

	@OneToMany
	protected Set<Prenotazione> prenotazioni;

	public Postazione(String _descrizione, TipoPostazione _tipoPostazione, int _numeroMassimoOccupanti,
			Edificio _edificio) {
		this.descrizione = _descrizione;
		this.tipoPostazione = _tipoPostazione;
		this.numeroMassimoOccupanti = _numeroMassimoOccupanti;
		this.edificio = _edificio;
	}

}
