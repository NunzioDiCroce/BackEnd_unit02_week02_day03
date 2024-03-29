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

import com.example.GestionePrenotazioniWS.entities.Utente;
import com.example.GestionePrenotazioniWS.entities.UtentePayload;
import com.example.GestionePrenotazioniWS.services.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody UtentePayload body) {
		Utente created = utenteService.save(body);
		return created;
	}

	@GetMapping("")
	public List<Utente> getUsers() {
		return utenteService.findAll();
	}

	@GetMapping("/{userId}")
	public Utente getUserById(@PathVariable long userId) {
		return utenteService.findById(userId);

	}

	@PutMapping("/{userId}")
	public Utente updateUser(@PathVariable long userId, @RequestBody UtentePayload body) {
		return utenteService.findByIdAndUpdate(userId, body);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable long userId) {
		utenteService.findByIdAndDelete(userId);
	}

}
