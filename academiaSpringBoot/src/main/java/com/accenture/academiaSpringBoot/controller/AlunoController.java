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
import com.accenture.academiaSpringBoot.model.Aluno;
import com.accenture.academiaSpringBoot.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")


public class AlunoController {
	
//	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@PostMapping("/create")
	public Aluno criarAluno(@Valid @RequestBody Aluno aluno) {
		return this.alunoRepository.save(aluno);
		
			
		//alunos.add(aluno);
		//return "ALUNO inserido na lista com sucesso";

	}

	@GetMapping("/list")
	public List<Aluno> listAlunos() {		
		return this.alunoRepository.findAll();
		//return alunos;
	}

	@GetMapping("/procura/{id}")
	public Optional<Aluno> procuraAluno(@PathVariable("id") int id) {		
		Optional<Aluno> alunoFinder = this.alunoRepository.findById(id);
		if (alunoFinder.isPresent()) {
			return alunoFinder;
		}else {
			return Optional.empty();
		}
		
		
		//Aluno procurado = null;
		//for(Aluno aluno: alunos) {
		//	if (aluno.getId() == id) {
		//		procurado = aluno;
		//	}
		//}
		//return procurado;
	}

	@PutMapping("/update/{id}")
	public String updateAluno(@PathVariable("id")int id, @RequestBody Aluno newAluno) {
	Optional<Aluno> oldAluno = this.alunoRepository.findById(id);
	
	if (oldAluno.isPresent()) {
		Aluno aluno = oldAluno.get();
		aluno.setNome(newAluno.getNome());
		aluno.setCpf(newAluno.getCpf());
		aluno.setIdade(newAluno.getIdade());
		aluno.setCurso(newAluno.getCurso());
		alunoRepository.save(aluno);
		return "Dados do Aluno alterado com sucesso!";
	}else {
		return "Aluno não existe no banco de dados!";
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


	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Aluno> alunoFinder = this.alunoRepository.findById(id);
	
		if (alunoFinder.isPresent()) {
			alunoRepository.delete(alunoFinder.get());
			return "Aluno excluído com sucesso!";
		}else {
			return "Aluno não existe no banco de dados!";
		}
	
	}
		//Aluno a = null;
		//boolean encontrou = false;
		//for (Aluno aluno : alunos) {
		//	if (aluno.getId() == id) {
		//		encontrou = true;
		//		a = aluno;
		//	}
	//	}
	//	if (encontrou == true) {
	//		alunos.remove(a);
		//}
	//}
}