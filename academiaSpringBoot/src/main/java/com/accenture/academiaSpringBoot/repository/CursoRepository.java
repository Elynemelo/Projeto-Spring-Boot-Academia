package com.accenture.academiaSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.academiaSpringBoot.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}