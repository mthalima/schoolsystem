package com.schoolsys.schooldemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

	//atributos
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;

	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST,
						CascadeType.MERGE, CascadeType.DETACH,
						CascadeType.REFRESH})
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;

	//construtores
	public Course(){

	}

	public Course(String title) {
		this.title = title;
	}

	//getters e setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	//add review ao curso
	public void addReview(Review theReview){
		if(reviews == null){
			reviews = new ArrayList<>();
		}
		reviews.add(theReview);
	}

	//add student to the course
	public void addStudent(Student theStudent){
		if(students == null){
			students = new ArrayList<>();
		}
		students.add(theStudent);
	}

	//toString()
	@Override
	public String toString() {
		return "Course{" +
				"title='" + title + '\'' +
				", id=" + id +
				'}';
	}
}
