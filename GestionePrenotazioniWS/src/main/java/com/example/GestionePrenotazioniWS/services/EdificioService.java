package com.example.GestionePrenotazioniWS.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.GestionePrenotazioniWS.entities.Edificio;
import com.example.GestionePrenotazioniWS.entities.EdificioPayload;
import com.example.GestionePrenotazioniWS.entities.Postazione;
import com.example.GestionePrenotazioniWS.exceptions.ItemNotFoundException;
import com.example.GestionePrenotazioniWS.repositories.EdificioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EdificioService {

	// * * * * * TO HANDLE CIRCULAR DEPENDENCY POSTAZIONE-EDIFICIO * * * * *
	private final EdificioRepository edificioRepository;
	// * * * * * TO HANDLE CIRCULAR DEPENDENCY POSTAZIONE-EDIFICIO * * * * *
	private final PostazioneService postazioneService;

	// * * * * * TO HANDLE CIRCULAR DEPENDENCY POSTAZIONE-EDIFICIO * * * * *
	public EdificioService(EdificioRepository edificioRepository, PostazioneService postazioneService) {
		this.edificioRepository = edificioRepository;
		this.postazioneService = postazioneService;
	}

	// save edificio
	public void save(Edificio _edificio) {
		edificioRepository.save(_edificio);
		log.info("Edificio con ID " + _edificio.getId() + " salvato con successo");

	}

	// save by EdificioPayload
	public Edificio save(EdificioPayload body) {
		Edificio nuovoEdificio = new Edificio(body.getNome(), body.getIndirizzo(), body.getCitta());

		// * * * * * TO HANDLE ONETOMANY RELATION * * * * *
		Set<Postazione> postazioni = body.getPostazioneIds().stream().map(postazioneService::findById)
				.collect(Collectors.toSet());
		// * * * * * TO HANDLE ONETOMANY RELATION * * * * *
		nuovoEdificio.setPostazioni(postazioni);

		return edificioRepository.save(nuovoEdificio);
	}

	public List<Edificio> findAll() {
		return edificioRepository.findAll();
	}

	public Edificio findById(long _id) throws ItemNotFoundException {
		return edificioRepository.findById(_id).orElseThrow(() -> new ItemNotFoundException(_id));

	}

	public Edificio findByIdAndUpdate(long id, EdificioPayload body) throws ItemNotFoundException {
		Edificio found = this.findById(id);

		found.setNome(body.getNome());
		found.setIndirizzo(body.getIndirizzo());
		found.setCitta(body.getCitta());

		// * * * * * TO HANDLE ONETOMANY RELATION * * * * *
		Set<Postazione> postazioni = body.getPostazioneIds().stream().map(postazioneService::findById)
				.collect(Collectors.toSet());
		// * * * * * TO HANDLE ONETOMANY RELATION * * * * *
		found.setPostazioni(postazioni);

		return edificioRepository.save(found);
	}

	public void findByIdAndDelete(long id) throws ItemNotFoundException {
		Edificio found = this.findById(id);
		edificioRepository.delete(found);
	}

}
