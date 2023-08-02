package com.example.GestionePrenotazioniWS.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "edifici")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j

@Builder

public class Edificio {

	@Id
	@GeneratedValue
	private long id;

	protected String nome;
	protected String indirizzo;
	protected String citta;

	@OneToMany
	protected Set<Postazione> postazioni;

	public Edificio(String _nome, String _indirizzo, String _citta) {
		this.nome = _nome;
		this.indirizzo = _indirizzo;
		this.citta = _citta;
	}

}
