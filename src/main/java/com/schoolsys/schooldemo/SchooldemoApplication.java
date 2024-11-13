package com.schoolsys.schooldemo;

import com.schoolsys.schooldemo.dao.AppDAO;
import com.schoolsys.schooldemo.entity.Course;
import com.schoolsys.schooldemo.entity.Instructor;
import com.schoolsys.schooldemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			
			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);
			
			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);
			
			//findInstructorWithCourses(appDAO);

			findCoursesForInstructors(appDAO);
		};
	}

	private void findCoursesForInstructors(AppDAO appDAO) {

		int theId=1;
		System.out.println("Encontrando instrutor de id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Nome: " + tempInstructor.getFirstName());

		//find couses of the instructor

		System.out.println("Procurando cursos do instrutor...");
		List<Course> courses = appDAO.findCoursesByInstructor(theId);

		tempInstructor.setCourses(courses);

		System.out.println("Cursos associados: " + tempInstructor.getCourses());


		System.out.println("FEITO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId=1;
		System.out.println("Encontrando instrutor de id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Nome: " + tempInstructor.getFirstName());
		System.out.println("Nome: " + tempInstructor.getCourses());

		System.out.println("FEITO!!!!!!!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		//cria instrutor
		Instructor tempInstructor =
				new Instructor("zallera@email.com", "zalllera", "vibes");

		//cria detalhes do instrutor
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"zalleravibes@yt.com",
						"hardware & gamming");

		//associa os detalhes com o instrutor
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//cria e associa cursos ao instrutor
		Course tempCourse1 = new Course("Curso - Desenvolvedor Backend");
		Course tempCourse2 = new Course("Curso - Mago do Hardware");

		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);

		System.out.println("SALVANDO PROFESSOR: " + tempInstructor + "...");
		System.out.println("CURSOS: " + tempInstructor.getCourses());
		//salva no db (tb salva os cursos)
		appDAO.save(tempInstructor);


		System.out.println("SALVO!!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId =2;

		System.out.println("Deletado detalhes de id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("FEITO >>>>>>>>>>>>>>>>");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		//get the instructor detail
		int theId =1;

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print
		System.out.println("Detalhes do Instrutor: " + tempInstructorDetail);

		//print o instrutor associado
		System.out.println("Instrutor: "+ tempInstructorDetail.getInstructor());

		System.out.println("FIM>>>>>>>>>>>>>>>");
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
