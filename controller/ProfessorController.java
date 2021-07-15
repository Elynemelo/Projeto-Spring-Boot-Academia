package com.accenture.academiaSpringBoot.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.academiaSpringBoot.model.Professor;

@RestController
@RequestMapping("/users")

public class ProfessorController {

	private List<Professor> professores = new ArrayList<Professor>();

	@PostMapping("/createProfessor")
	public String criarProfessor(@RequestBody Professor professor) {
		professores.add(professor);
		return "PROFESSOR(A) inserido na lista com sucesso!";

	}

	@GetMapping("/listProfessores")
	public List<Professor> listProfessores() {		
		return professores;
	}

	@GetMapping("/procuraProfessor/{id}")
	public Professor procuraProfessor(@PathVariable("id") int id) {		
		Professor procurado = null;
		for(Professor professor: professores) {
			if (professor.getId() == id) {
				procurado = professor;
			}
		}
		return procurado;
	}

	@PutMapping("/updateProfessor/{id}")
	public List<Professor> updateProfessor(@PathVariable("id")int id, @RequestBody Professor professor) {
		for(Professor p: professores) {
			if (p.getId() == id) {
				int i = professores.indexOf(p);
				professores.set(i,professor);
			}
		}
				
		
		return professores;
	}


	@DeleteMapping("/deleteProfessor/{id}")
	public void delete(@PathVariable("id") int id) {
		Professor p = null;
		boolean encontrou = false;
		for (Professor professor : professores) {
			if (professor.getId() == id) {
				encontrou = true;
				p = professor;
			}
		}
		if (encontrou == true) {
			professores.remove(p);
		}
	}
}
	
	
	
	
	
	
	
	
	

