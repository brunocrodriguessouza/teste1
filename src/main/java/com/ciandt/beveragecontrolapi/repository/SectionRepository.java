package com.ciandt.beveragecontrolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.beveragecontrolapi.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
