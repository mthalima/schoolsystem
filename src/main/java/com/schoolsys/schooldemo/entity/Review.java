package com.schoolsys.schooldemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="review")
public class Review {


	//define atribustos e mapeia
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "comment")
	private String comment;


	//constructors
	public Review(){

	}

	public Review(String comment) {
		this.comment = comment;
	}


	//getters e setters

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//toString()


	@Override
	public String toString() {
		return "Review{" +
				"comment='" + comment + '\'' +
				", id=" + id +
				'}';
	}
}
