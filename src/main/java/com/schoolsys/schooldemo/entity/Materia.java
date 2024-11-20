package com.schoolsys.schooldemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nomeMateria")
	private String nomeMateria;

	@Column(name = "cargaHoraria")
	private int cargaHoraria;

	@Column(name = "detalhesMaterias")
	private String detalhesMateria;
}
