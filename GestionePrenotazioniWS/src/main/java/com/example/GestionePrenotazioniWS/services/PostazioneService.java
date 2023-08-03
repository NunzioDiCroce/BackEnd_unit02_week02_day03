package com.example.GestionePrenotazioniWS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestionePrenotazioniWS.entities.Postazione;
import com.example.GestionePrenotazioniWS.entities.PostazionePayload;
import com.example.GestionePrenotazioniWS.exceptions.ItemNotFoundException;
import com.example.GestionePrenotazioniWS.repositories.PostazioneRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazioneRepository;

	@Autowired
	private EdificioService edificioService;

	// save postazione
	public void save(Postazione _postazione) {
		postazioneRepository.save(_postazione);
		log.info("Postazione con ID " + _postazione.getId() + " salvata con successo");

	}

	// save by PostazionePayload
	public Postazione save(PostazionePayload body) {
		Postazione nuovaPostazione = new Postazione(body.getDescrizione(), body.getTipoPostazione(),
				body.getNumeroMassimoOccupanti(), edificioService.findById(body.getEdificioId()));
		return postazioneRepository.save(nuovaPostazione);
	}

	public List<Postazione> findAll() {
		return postazioneRepository.findAll();
	}

	public Postazione findById(long _id) throws ItemNotFoundException {
		return postazioneRepository.findById(_id).orElseThrow(() -> new ItemNotFoundException(_id));

	}

	public Postazione findByIdAndUpdate(long id, PostazionePayload body) throws ItemNotFoundException {
		Postazione found = this.findById(id);

		found.setDescrizione(body.getDescrizione());
		found.setTipoPostazione(body.getTipoPostazione());
		found.setNumeroMassimoOccupanti(body.getNumeroMassimoOccupanti());

		return postazioneRepository.save(found);
	}

	public void findByIdAndDelete(long id) throws ItemNotFoundException {
		Postazione found = this.findById(id);
		postazioneRepository.delete(found);
	}

}
