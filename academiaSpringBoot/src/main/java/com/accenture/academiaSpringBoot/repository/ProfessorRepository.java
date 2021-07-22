package com.accenture.academiaSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.academiaSpringBoot.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
