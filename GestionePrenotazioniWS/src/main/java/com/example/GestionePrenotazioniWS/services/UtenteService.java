package com.example.GestionePrenotazioniWS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestionePrenotazioniWS.entities.Utente;
import com.example.GestionePrenotazioniWS.entities.UtentePayload;
import com.example.GestionePrenotazioniWS.exceptions.ItemNotFoundException;
import com.example.GestionePrenotazioniWS.repositories.UtenteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	// save utente
	public void save(Utente _utente) {
		utenteRepository.save(_utente);
		log.info("Utente con ID " + _utente.getId() + " salvato con successo");

	}

	// save by UtentePayload
	public Utente save(UtentePayload body) {
		Utente nuovoUtente = new Utente(body.getUserName(), body.getNome(), body.getMail());
		return utenteRepository.save(nuovoUtente);
	}

	public List<Utente> findAll() {
		return utenteRepository.findAll();
	}

	public Utente findById(long _id) throws ItemNotFoundException {
		return utenteRepository.findById(_id).orElseThrow(() -> new ItemNotFoundException(_id));

	}

	public Utente findByIdAndUpdate(long id, UtentePayload body) throws ItemNotFoundException {
		Utente found = this.findById(id);

		found.setUserName(body.getUserName());
		found.setNome(body.getNome());
		found.setMail(body.getMail());

		return utenteRepository.save(found);
	}

	public void findByIdAndDelete(long id) throws ItemNotFoundException {
		Utente found = this.findById(id);
		utenteRepository.delete(found);
	}

}
