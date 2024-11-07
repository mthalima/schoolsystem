package com.schoolsys.schooldemo.dao;

import com.schoolsys.schooldemo.entity.Instructor;
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
}
