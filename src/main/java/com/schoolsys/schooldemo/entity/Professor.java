package com.schoolsys.schooldemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sobrenome")
	private String sobrenome;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor",
				cascade = {CascadeType.MERGE, CascadeType.REFRESH,
							CascadeType.PERSIST, CascadeType.DETACH})
	private List<Materia> materias;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor",
				cascade = {CascadeType.MERGE, CascadeType.REFRESH,
							CascadeType.PERSIST, CascadeType.DETACH})
	private List<Turma> turmas;

	//CONSTRUCTORS
	public Professor(){

	}

	public Professor(String nome, String sobrenome, String email, String telefone, List<Materia> materias, List<Turma> turmas) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.materias = materias;
		this.turmas = turmas;
	}

	//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "Professor{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", email='" + email + '\'' +
				", telefone='" + telefone + '\'' +
				", materias=" + materias +
				", turmas=" + turmas +
				'}';
	}
}
