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

import com.example.GestionePrenotazioniWS.entities.Edificio;
import com.example.GestionePrenotazioniWS.entities.EdificioPayload;
import com.example.GestionePrenotazioniWS.services.EdificioService;

@RestController
@RequestMapping("/edifici")
public class EdificioController {

	@Autowired
	private EdificioService edificioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Edificio saveBuilding(@RequestBody EdificioPayload body) {
		Edificio created = edificioService.save(body);
		return created;
	}

	@GetMapping("")
	public List<Edificio> getBuildings() {
		return edificioService.findAll();
	}

	@GetMapping("/{buildingId}")
	public Edificio getBuildingById(@PathVariable long buildingId) {
		return edificioService.findById(buildingId);

	}

	@PutMapping("/{buildingId}")
	public Edificio updateBuilding(@PathVariable long buildingId, @RequestBody EdificioPayload body) {
		return edificioService.findByIdAndUpdate(buildingId, body);
	}

	@DeleteMapping("/{buildingId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBuilding(@PathVariable long buildingId) {
		edificioService.findByIdAndDelete(buildingId);
	}

}
