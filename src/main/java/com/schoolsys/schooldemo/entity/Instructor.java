package com.schoolsys.schooldemo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor{

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor",
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;


	//construtores
	public Instructor(){

	}

	public Instructor(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//getters e setters


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	//checa e cria lista de cursos
	public void addCourse(Course tempCourse){

		if (courses == null){
			courses = new ArrayList<>();
		}

		courses.add(tempCourse);

		tempCourse.setInstructor(this);
	}

	@Override
	public String toString() {
		return "Instructor{" +
				"email='" + email + '\'' +
				", id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", instructorDetail=" + instructorDetail +
				'}';
	}
}
