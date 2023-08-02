package com.example.GestionePrenotazioniWS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestionePrenotazioniWS.entities.Edificio;
import com.example.GestionePrenotazioniWS.entities.EdificioPayload;
import com.example.GestionePrenotazioniWS.entities.Postazione;
import com.example.GestionePrenotazioniWS.entities.PostazionePayload;
import com.example.GestionePrenotazioniWS.exceptions.ItemNotFoundException;
import com.example.GestionePrenotazioniWS.repositories.EdificioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepository;
	private PostazioneService postazioneService;

	// save edificio
	public void save(Edificio _edificio) {
		edificioRepository.save(_edificio);
		log.info("Edificio con ID " + _edificio.getId() + " salvato con successo");

	}

	// save by EdificioPayload
	public Edificio save(EdificioPayload body) {
		Edificio nuovoEdificio = new Edificio(body.getNome(), body.getIndirizzo(), body.getCitta(), postazioneService.findById(body.getPostazioneId());
		return EdificioRepository.save(nuovoEdificio);
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
		found.setEdificio(body.getEdificio());

		return postazioneRepository.save(found);
	}

	public void findByIdAndDelete(long id) throws ItemNotFoundException {
		Postazione found = this.findById(id);
		postazioneRepository.delete(found);
	}

}
