package com.schoolsys.schooldemo.dao;

import com.schoolsys.schooldemo.entity.Course;
import com.schoolsys.schooldemo.entity.Instructor;
import com.schoolsys.schooldemo.entity.InstructorDetail;
import com.schoolsys.schooldemo.entity.Student;

import java.util.List;

public interface AppDAO {

	void save(Instructor theInstructor);

	Instructor findInstructorById(int theId);

	void deleteInstructor(int theId);

	InstructorDetail findInstructorDetailById(int theId);

	void deleteInstructorDetailById(int theId);

	List<Course> findCoursesByInstructor(int theId);

	Instructor findInstructorByIdJoinFetch(int theId);

	void update(Instructor tempInstructor);

	void update(Course tempCourse);

	Course findCourseById(int theId);

	void deleteCourseById(int theId);

	void save(Course theCourse);

	Course findCourseReviewsByCourseId(int theId);

	Course findCourseStudentsByCourseId(int theId);

	Student findStudentAndCoursesByStudentId(int theId);

	void update(Student theStudent);

	void deleteStudentById(int theId);
}
