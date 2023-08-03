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

import com.example.GestionePrenotazioniWS.entities.Postazione;
import com.example.GestionePrenotazioniWS.entities.PostazionePayload;
import com.example.GestionePrenotazioniWS.services.PostazioneService;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {

	private final PostazioneService postazioneService;

	@Autowired
	public PostazioneController(PostazioneService postazioneService) {
		this.postazioneService = postazioneService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione saveSeat(@RequestBody PostazionePayload body) {
		Postazione created = postazioneService.save(body);
		return created;
	}

	@GetMapping("")
	public List<Postazione> getSeats() {
		return postazioneService.findAll();
	}

	@GetMapping("/{seatId}")
	public Postazione getSeatById(@PathVariable long seatId) {
		return postazioneService.findById(seatId);

	}

	@PutMapping("/{seatId}")
	public Postazione updateSeat(@PathVariable long seatId, @RequestBody PostazionePayload body) {
		return postazioneService.findByIdAndUpdate(seatId, body);
	}

	@DeleteMapping("/{seatId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSeat(@PathVariable long seatId) {
		postazioneService.findByIdAndDelete(seatId);
	}

}
