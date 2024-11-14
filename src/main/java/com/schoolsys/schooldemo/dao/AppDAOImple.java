package com.schoolsys.schooldemo.dao;

import com.schoolsys.schooldemo.entity.Course;
import com.schoolsys.schooldemo.entity.Instructor;
import com.schoolsys.schooldemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AppDAOImple implements AppDAO{

	//define campo para gerenciar entidade
	private EntityManager entityManager;

	//injeta a o gerenciador de entidade usando constructor injection

	@Autowired
	public AppDAOImple(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {
		//procura
		Instructor theInstructor = entityManager.find(Instructor.class, theId);

		//deleta
		entityManager.remove(theInstructor);

		System.out.println("Id" + theId + "Deletado");
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {

		//cata
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

		//remove link bi-direcional
		tempInstructorDetail.getInstructor().setInstructorDetail(null);


		//deleta
		entityManager.remove(tempInstructorDetail);
	}


	//esse metodo cria uma query que retorna a lista de cursos associada ao id
	@Override
	public List<Course> findCoursesByInstructor(int theId) {

		//cria a query
		TypedQuery<Course> query = entityManager.createQuery(
				"from Course where instructor.id= :data", Course.class);

		query.setParameter("data", theId);

		//executa a query

		List<Course> courses = query.getResultList();

		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {

		//cria query
		TypedQuery<Instructor> query = entityManager.createQuery(
				"select i from Instructor i "
				+ "JOIN FETCH i.courses "
				+"where i.id = :data", Instructor.class);

		query.setParameter("data", theId);

		Instructor instructor = query.getSingleResult();

		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {

		//update the instructor
		entityManager.merge(tempInstructor);
	}


}
