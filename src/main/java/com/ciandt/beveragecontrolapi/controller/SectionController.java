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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.beveragecontrolapi.event.ResourceCreatedEvent;
import com.ciandt.beveragecontrolapi.model.Section;
import com.ciandt.beveragecontrolapi.repository.SectionRepository;

@RestController
@RequestMapping("/sections")
public class SectionController {

	@Autowired
	private SectionRepository sectionRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Section> getAll() {
		return sectionRepository.findAll();
	}

	@GetMapping("/{id}")
	public Section getById(@PathVariable Long id) {
		return sectionRepository.findOne(id);
	}

	@PostMapping
	public ResponseEntity<Section> InsertBeverage(@Valid @RequestBody Section section, HttpServletResponse response) {
		Section savedBeverage = sectionRepository.save(section);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, savedBeverage.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBeverage);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		sectionRepository.delete(id);
	}
	
	
}
