package com.accenture.academiaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Aluno {

		private int id;
		private String nome;
		private String cpf;
		private int idade;
		private String nomeCurso;
		
}
