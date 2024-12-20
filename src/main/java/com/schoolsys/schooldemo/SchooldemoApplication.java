package com.schoolsys.schooldemo;

import com.schoolsys.schooldemo.dao.AppDAO;
import com.schoolsys.schooldemo.entity.*;
import jdk.swing.interop.SwingInterOpUtils;
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

			//findCoursesForInstructors(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);

			//updateCourse(appDAO);

			//deleteInstructor(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO);

			//createInstructorWithReviews(appDAO);

			//retrieveCourseAndReviews(appDAO);

			//deleteCourseAndReviews(appDAO);

			//createCourseWithStudents(appDAO);

			//findCourseAndStudents(appDAO);

			//findStudentAndCourses(appDAO);
			
			//addMoreCoursesForStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;

		System.out.println("DELETANDO ESTUDANTE DE ID: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("FEITO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		//procura estudante
		int theId = 3;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		//cria mais cursos para o estudante

		Course tempCourse1 = new Course("Cozinha com o Chef");
		Course tempCourse2 = new Course("Desenvolvimento de Jogos- GODOT");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("ATUALIZANDO ESTUDANTE: " + tempStudent);
		System.out.println("CURSOS ADICIONADOS: " + tempStudent.getCourses());

		//salva com appDAO
		appDAO.update(tempStudent);

		System.out.println("FEITO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId = 3;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("ESTUDANTE: " + tempStudent);
		System.out.println("CURSOS: " + tempStudent.getCourses());

		System.out.println("FEITO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;

		Course tempCourse = appDAO.findCourseStudentsByCourseId(theId);

		System.out.println("Curso: " + tempCourse);
		System.out.println("Estudantes: " + tempCourse.getStudents());

		System.out.println("FEITO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}


	private void createCourseWithStudents(AppDAO appDAO) {

		//cria um curso
		Course tempCourse = new Course("Curso para desenvolvedores - JAVA Spring Boot");

		//cria os estudantes associados a esse curso
		Student tempStudent1 = new Student("Joao", "Joao@bolinha.com", "Pedro");
		Student tempStudent2 = new Student("Maria", "Mariinha@bolinha.com", "Mariinha");
		Student tempStudent3 = new Student("Belle", "bellibelinha@bolinha.com", "Belinha");

		//add students ao curso
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);

		//salva o curso e estudantes associados
		System.out.println("SALVANDO CURSO E ESTUDANTES........");

		appDAO.save(tempCourse);

		System.out.println("FEITO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deletando curso de id "+theId+ " ...");

		appDAO.deleteCourseById(theId);

		System.out.println("Feito>>>>>>>>>>>>>>>>>>");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		//pega curso
		int theId = 10;
		Course tempCourse = appDAO.findCourseReviewsByCourseId(theId);

		//printa curso
		System.out.println(tempCourse);

		//print reviews
		System.out.println(tempCourse.getReviews());

		System.out.println("Feito>>>>>>>>>>>>>>>>>>");
	}

	private void createInstructorWithReviews(AppDAO appDAO) {

		//cria curso
		Course tempCourse = new Course("Curso de vender curso(ATENÇÃO!!! isso é um scam)");

		//add reviews
		tempCourse.addReview(new Review("Lixo de curso, esse cara é um scammer"));
		tempCourse.addReview(new Review("Curso de vender curso!"));
		tempCourse.addReview(new Review("Comprei e me arrependi"));

		//salva
		appDAO.save(tempCourse);

		System.out.println("Feito>>>>>>>>>>>>>>>>>>");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 12;
		System.out.println("Deletando curso de id "+theId+ " ...");

		appDAO.deleteCourseById(theId);

		System.out.println("FIM>>>>>>>>>>>>>>>");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		//find the course
		System.out.println("Procurando curso de id: "+ theId+ " ...");
		Course tempCourse = appDAO.findCourseById(theId);

		//update course
		tempCourse.setTitle("Profissional game developer");
		appDAO.update(tempCourse);

		System.out.println("Feito>>>>>>>>>>>>>>>>>>");
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		//find the instructor
		System.out.println("Procurando instrutor de id: "+ theId +" ...");
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update the Instructor
		System.out.println("Atualizando instrutor de id: "+ theId +" ...");
		tempInstructor.setLastName("XICSO");

		//chama o metodo de salvar no db
		appDAO.update(tempInstructor);

		System.out.println("Feito>>>>>>>>>>>>>>>>>>");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		//find instructor
		System.out.println("Procurando Instrutor de id: "+ theId +" ...");
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor name: "+ tempInstructor.getFirstName());
		System.out.println("Cursos: "+ tempInstructor.getCourses());

		System.out.println("Feito>>>>>>>>>>>>>>>>>>");
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
		int theId = 1;

		System.out.println("Deletando instrutor de ID >>>>>>>>>>>>>>"+ theId);
		appDAO.deleteInstructor(theId);

		System.out.println("FIM>>>>>>>>>>>>>>>");
	}


}
