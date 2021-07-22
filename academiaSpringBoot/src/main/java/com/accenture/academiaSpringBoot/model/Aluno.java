package com.accenture.academiaSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;


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
@Entity
@Table (name = "tb_aluno")

@GroupSequence({Aluno.class})
public class Aluno {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		
		@NotBlank(message = "O campo NOME é obrigatório, por favor, informe um nome!")
		@Length(min = 3, max = 35, message = "O nome deverá ter no máximo {35} caracteres")
		private String nome;
		
		@NotBlank(message = "O CPF é obrigatório!")		
		@Length(min = 11, max = 11, message = "O CPF deve conter {11} caracteres")
		private String cpf;
		
		@Min(18)
		private int idade;
		
		@ManyToOne
		@JoinColumn(name = "curso_id")
		private Curso curso;
		
}
