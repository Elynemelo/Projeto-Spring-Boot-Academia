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
import com.accenture.academiaSpringBoot.model.Aluno;

@RestController
@RequestMapping("/users")


public class AlunoController {

	private List<Aluno> alunos = new ArrayList<Aluno>();

	@PostMapping("/createAluno")
	public String criarAluno(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return "ALUNO inserido na lista com sucesso";

	}

	@GetMapping("/listAlunos")
	public List<Aluno> listAlunos() {		
		return alunos;
	}

	@GetMapping("/procuraAluno/{id}")
	public Aluno procuraAluno(@PathVariable("id") int id) {		
		Aluno procurado = null;
		for(Aluno aluno: alunos) {
			if (aluno.getId() == id) {
				procurado = aluno;
			}
		}
		return procurado;
	}

	@PutMapping("/updateAluno/{id}")
	public List<Aluno> updateAluno(@PathVariable("id")int id, @RequestBody Aluno aluno) {
		for(Aluno a: alunos) {
			if (a.getId() == id) {
				int i = alunos.indexOf(a);
				alunos.set(i,aluno);
			}
		}
				
		
		return alunos;
	}


	@DeleteMapping("/deleteAluno/{id}")
	public void delete(@PathVariable("id") int id) {
		Aluno a = null;
		boolean encontrou = false;
		for (Aluno aluno : alunos) {
			if (aluno.getId() == id) {
				encontrou = true;
				a = aluno;
			}
		}
		if (encontrou == true) {
			alunos.remove(a);
		}
	}
}