package com.example.GestionePrenotazioniWS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionePrenotazioniWS.entities.Prenotazione;
import com.example.GestionePrenotazioniWS.entities.PrenotazionePayload;
import com.example.GestionePrenotazioniWS.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	private final PrenotazioneService prenotazioneService;

	@Autowired
	public PrenotazioneController(PrenotazioneService prenotazioneService) {
		this.prenotazioneService = prenotazioneService;
	}

	// METHOD WITH CUSTOM QUERY
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione saveReservation(@RequestBody PrenotazionePayload body) {
		Prenotazione created = prenotazioneService.effettuaPrenotazione(body);
		return created;
	}

	@GetMapping("")
	public List<Prenotazione> getReservations() {
		return prenotazioneService.findAll();
	}

	@GetMapping("/{reservationId}")
	public Prenotazione getReservationById(@PathVariable long reservationId) {
		return prenotazioneService.findById(reservationId);

	}

	@PutMapping("/{reservationId}")
	public Prenotazione updateReservation(@PathVariable long reservationId, @RequestBody PrenotazionePayload body) {
		return prenotazioneService.findByIdAndUpdate(reservationId, body);
	}

	@DeleteMapping("/{reservationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteReservation(@PathVariable long reservationId) {
		prenotazioneService.findByIdAndDelete(reservationId);
	}

}
