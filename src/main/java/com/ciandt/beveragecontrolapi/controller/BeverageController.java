package com.ciandt.beveragecontrolapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.beveragecontrolapi.event.ResourceCreatedEvent;
import com.ciandt.beveragecontrolapi.model.Beverage;
import com.ciandt.beveragecontrolapi.repository.BeverageRepository;
import com.ciandt.beveragecontrolapi.service.BeverageService;

@RestController
@RequestMapping("/beverages")
public class BeverageController {

	@Autowired
	private BeverageRepository beverageRepository;

	@Autowired
	private BeverageService beverageService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Beverage> getAll() {
		return beverageRepository.findAll();
	}

	@GetMapping("/{id}")
	public Beverage getById(@PathVariable Long id) {
		return beverageRepository.findOne(id);
	}

	@PostMapping
	public ResponseEntity<Beverage> InsertBeverage(@Valid @RequestBody Beverage beverage,
			HttpServletResponse response) {
		Beverage savedBeverage = beverageRepository.save(beverage);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedBeverage.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBeverage);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		beverageRepository.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Beverage> update(@PathVariable Long id, @Valid @RequestBody Beverage beverage) {
		Beverage savedPeople = beverageService.update(id, beverage);
		return ResponseEntity.ok(savedPeople);
	}

	@GetMapping("/sections/{id}")
	List<Beverage> findBySection(@PathVariable Long id) {
		List<Beverage> beverageList = beverageService.findBySection(id);
		return beverageList;
	}

}
