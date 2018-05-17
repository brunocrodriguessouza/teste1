package com.ciandt.beveragecontrolapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.beveragecontrolapi.model.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
	
	List<Beverage> findBySection(Long id);

}
