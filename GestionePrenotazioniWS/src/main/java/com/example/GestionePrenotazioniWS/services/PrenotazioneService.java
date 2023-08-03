package com.example.GestionePrenotazioniWS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionePrenotazioniWS.entities.Prenotazione;
import com.example.GestionePrenotazioniWS.entities.PrenotazionePayload;
import com.example.GestionePrenotazioniWS.exceptions.ItemNotFoundException;
import com.example.GestionePrenotazioniWS.repositories.PrenotazioneRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrenotazioneService {

	private final PrenotazioneRepository prenotazioneRepository;
	private final UtenteService utenteService;
	private final PostazioneService postazioneService;

	public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, UtenteService utenteService,
			PostazioneService postazioneService) {
		this.prenotazioneRepository = prenotazioneRepository;
		this.utenteService = utenteService;
		this.postazioneService = postazioneService;
	}

	// save prenotazione
	public void save(Prenotazione _prenotazione) {
		prenotazioneRepository.save(_prenotazione);
		log.info("Prenotazione con ID " + _prenotazione.getId() + " salvata con successo");

	}

	// save by PrenotazionePayload
	public Prenotazione save(PrenotazionePayload body) {
		Prenotazione nuovaPrenotazione = new Prenotazione(utenteService.findById(body.getUtenteId()),
				body.getDataPrenotazione(), postazioneService.findById(body.getPostazioneId()));
		return prenotazioneRepository.save(nuovaPrenotazione);
	}

	public List<Prenotazione> findAll() {
		return prenotazioneRepository.findAll();
	}

	public Prenotazione findById(long _id) throws ItemNotFoundException {
		return prenotazioneRepository.findById(_id).orElseThrow(() -> new ItemNotFoundException(_id));

	}

	public Prenotazione findByIdAndUpdate(long id, PrenotazionePayload body) throws ItemNotFoundException {
		Prenotazione found = this.findById(id);

		found.setUtente(utenteService.findById(body.getUtenteId()));
		found.setDataPrenotazione(body.getDataPrenotazione());
		found.setPostazione(postazioneService.findById(body.getPostazioneId()));
		return prenotazioneRepository.save(found);
	}

	public void findByIdAndDelete(long id) throws ItemNotFoundException {
		Prenotazione found = this.findById(id);
		prenotazioneRepository.delete(found);
	}

}
