package com.accenture.academiaSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
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
@Table (name = "tb_curso")

@GroupSequence({Curso.class})

	public class Curso {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int cod;
		
		@NotBlank(message = "É obrigatório informar um nome!")
		@Length(min = 3, max = 20, message = "O nome do curso deve ter entre {3} e {20} caracteres!")
		private String nome;
		
		
		
}

