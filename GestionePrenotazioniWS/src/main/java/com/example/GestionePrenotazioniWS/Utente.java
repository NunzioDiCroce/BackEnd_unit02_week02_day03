package com.example.GestionePrenotazioniWS;

import java.util.Set;

import com.example.GestionePrenotazioni.Prenotazione;

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
@Table(name = "utenti")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j

@Builder

public class Utente {

	@Id
	@GeneratedValue
	private long id;

	protected String userName;
	protected String nome;
	protected String mail;

	@OneToMany
	protected Set<Prenotazione> prenotazioni;

	public Utente(String _userName, String _nome, String _mail) {
		this.userName = _userName;
		this.nome = _nome;
		this.mail = _mail;
	}

}
