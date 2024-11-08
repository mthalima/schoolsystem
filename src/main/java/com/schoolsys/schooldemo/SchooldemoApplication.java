package com.schoolsys.schooldemo;

import com.schoolsys.schooldemo.dao.AppDAO;
import com.schoolsys.schooldemo.entity.Instructor;
import com.schoolsys.schooldemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchooldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchooldemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{
			//createInstructor(appDAO);

			//findInstructor(appDAO);
			
			deleteInstructor(appDAO);
		};
	}



	private void findInstructor(AppDAO appDAO) {

		int theId = 3;
		System.out.println("instrutor:" + theId);

		Instructor theInstructor = appDAO.findInstructorById(theId);

		System.out.println("name:" + theInstructor.getFirstName());

		System.out.println("detalhes:" + theInstructor.getInstructorDetail().getHobby());
	}

	private void createInstructor(AppDAO appDAO) {

		//cria instrutor
		Instructor tempInstructor =
				new Instructor("belina@email.com", "belina", "vibes");

		//cria detalhes do instrutor
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("belinamake/ytchannel", "makes e papas");

		//associa o objeto
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//salva o objeto
		//isso tb salva os detalhes porque do CascadeType.ALL
		System.out.println("salvando o instrutor:" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("SALVO!!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deletando instrutor de ID >>>>>>>>>>>>>>"+ theId);
		appDAO.deleteInstructor(theId);
	}


}
