package com.schoolsys.schooldemo.dao;

import com.schoolsys.schooldemo.entity.Course;
import com.schoolsys.schooldemo.entity.Instructor;
import com.schoolsys.schooldemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

	void save(Instructor theInstructor);

	Instructor findInstructorById(int theId);

	void deleteInstructor(int theId);

	InstructorDetail findInstructorDetailById(int theId);

	void deleteInstructorDetailById(int theId);

	List<Course> findCoursesByInstructor(int theId);

	Instructor findInstructorByIdJoinFetch(int theId);








}
