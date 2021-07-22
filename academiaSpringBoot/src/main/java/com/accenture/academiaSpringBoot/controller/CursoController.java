package com.accenture.academiaSpringBoot.controller;

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
import com.accenture.academiaSpringBoot.model.Curso;
import com.accenture.academiaSpringBoot.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")

public class CursoController {


	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping("/create")
	public Curso criarCurso(@Valid @RequestBody Curso curso) {
		return this.cursoRepository.save(curso);

	}

	@GetMapping("/list")
	public List<Curso> listCursos() {		
		return this.cursoRepository.findAll();
		
	}

	@GetMapping("/procura/{id}")
	public Optional<Curso> procuraCurso(@PathVariable("id") int id) {		
		Optional<Curso> cursoFinder = this.cursoRepository.findById(id);
		if (cursoFinder.isPresent()) {
			return cursoFinder;
		}else {
			return Optional.empty();
		}
		
	}

	@PutMapping("/update/{id}")
	public String updateCurso(@PathVariable("id")int id, @RequestBody Curso newCurso) {
	Optional<Curso> oldCurso = this.cursoRepository.findById(id);
	
	if (oldCurso.isPresent()) {
		Curso curso = oldCurso.get();
		curso.setCod(newCurso.getCod());
		curso.setNome(newCurso.getNome());
		cursoRepository.save(curso);
		return "Dados do Curso alterado com sucesso!";
	}else {
		return "Curso não existe no banco de dados!";
	}
	
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Curso> cursoFinder = this.cursoRepository.findById(id);
	
		if (cursoFinder.isPresent()) {
			cursoRepository.delete(cursoFinder.get());
			return "Curso excluído com sucesso!";
		}else {
			return "Curso não existe no banco de dados!";
		}
	
	}

}



