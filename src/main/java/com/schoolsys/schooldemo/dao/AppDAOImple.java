package com.schoolsys.schooldemo.dao;

import com.schoolsys.schooldemo.entity.Instructor;
import com.schoolsys.schooldemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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


}
