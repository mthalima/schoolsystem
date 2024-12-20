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

	@Column(name = "descricaoMateria")
	private String descricaoMateria;

	//CONSTRUTORES
	public Materia() {
	}

	public Materia(String nomeMateria, int cargaHoraria, String descricaoMateria) {
		this.nomeMateria = nomeMateria;
		this.cargaHoraria = cargaHoraria;
		this.descricaoMateria = descricaoMateria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
