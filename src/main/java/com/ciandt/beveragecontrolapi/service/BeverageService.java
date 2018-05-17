package com.ciandt.beveragecontrolapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ciandt.beveragecontrolapi.model.Beverage;
import com.ciandt.beveragecontrolapi.repository.BeverageRepository;

@Service
public class BeverageService {

	@Autowired
	private BeverageRepository beverageRepository;
	
	public Beverage update(Long id, Beverage beverage) {
		Beverage savedBeverage = findBeverageById(id);
		BeanUtils.copyProperties(beverage, savedBeverage, "id");
		return beverageRepository.save(savedBeverage);
	}
	
	private Beverage findBeverageById(Long id) {
		Beverage savedBeverage = beverageRepository.findOne(id);
		if (savedBeverage == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedBeverage;
	}

	public List<Beverage> findBySection(Long id) {
		return beverageRepository.findBySection(id);
	}
	 
	public void teste() {
		
	}
}
