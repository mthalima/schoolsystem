package com.schoolsys.schooldemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {

	private int id;

	private String nome;

	private String sobrenome;

	private List<Materia> materias;
}
