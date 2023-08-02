package com.example.GestionePrenotazioniWS.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class UtentePayload {

	protected String userName;
	protected String nome;
	protected String mail;

}
