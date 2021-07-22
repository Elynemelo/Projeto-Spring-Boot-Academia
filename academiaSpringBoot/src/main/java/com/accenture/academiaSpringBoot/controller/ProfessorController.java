package com.accenture.academiaSpringBoot.controller;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.academiaSpringBoot.model.Professor;
import com.accenture.academiaSpringBoot.repository.ProfessorRepository;

@RestController
@RequestMapping("/users")


public class ProfessorController {

//	private List<Professor> professores = new ArrayList<Professor>();
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@PostMapping("/createProfessor")
	public Professor criarProfessor(@Valid @RequestBody Professor professor) {
		return this.professorRepository.save(professor);
		
		//alunos.add(aluno);
		//return "ALUNO inserido na lista com sucesso";

	}

	@GetMapping("/listProfessores")
	public List<Professor> listProfessores() {		
		return this.professorRepository.findAll();
		//return professores;
	}

	@GetMapping("/procuraProfessor/{id}")
	public Optional<Professor> procuraProfessor(@PathVariable("id") int id) {		
		Optional<Professor> professorFinder = this.professorRepository.findById(id);
		if (professorFinder.isPresent()) {
			return professorFinder;
		}else {
			return Optional.empty();
		}

		
		//Professor procurado = null;
		//for(Professor professor: professores) {
		//	if (professor.getId() == id) {
		//		procurado = professor;
		//	}
		//}
		//return procurado;
	}

	@PutMapping("/updateProfessor/{id}")
	public String updateProfessor(@PathVariable("id")int id, @RequestBody Professor newProfessor) {
	Optional<Professor> oldProfessor = this.professorRepository.findById(id);
	
	if (oldProfessor.isPresent()) {
		Professor professor = oldProfessor.get();
		professor.setNome(newProfessor.getNome());
		professor.setCpf(newProfessor.getCpf());
		professor.setIdade(newProfessor.getIdade());
		professor.setSalario(newProfessor.getSalario());
		professorRepository.save(professor);
		return "Dados do Professor alterado com sucesso!";
	}else {
		return "Professor não existe no banco de dados!";
	}
	
	//*
//	public List<Aluno> updateAluno(@PathVariable("id")int id, @RequestBody Aluno aluno) {
//		for(Aluno a: alunos) {
//		if (a.getId() == id) {
//				int i = alunos.indexOf(a);
//				alunos.set(i,aluno);
//			}
//		}
//		return alunos;
	}


	@DeleteMapping("/deleteProfessor/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Professor> professorFinder = this.professorRepository.findById(id);
	
		if (professorFinder.isPresent()) {
			professorRepository.delete(professorFinder.get());
			return "Professor excluído com sucesso!";
		}else {
			return "Professor não existe no banco de dados!";
		}
	
	}
		//Professor a = null;
		//boolean encontrou = false;
		//for (Professor professor : professores) {
		//	if (professor.getId() == id) {
		//		encontrou = true;
		//		a = professor;
		//	}
	//	}
	//	if (encontrou == true) {
	//		professores.remove(a);
		//}
	//}
}