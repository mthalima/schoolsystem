package com.schoolsys.schooldemo.dao;

import com.schoolsys.schooldemo.entity.Instructor;
import com.schoolsys.schooldemo.entity.InstructorDetail;

public interface AppDAO {

	void save(Instructor theInstructor);

	Instructor findInstructorById(int theId);

	void deleteInstructor(int theId);

	InstructorDetail findInstructorDetailById(int theId);

}
