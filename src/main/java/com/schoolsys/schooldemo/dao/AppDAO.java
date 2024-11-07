package com.schoolsys.schooldemo.dao;

import com.schoolsys.schooldemo.entity.Instructor;

public interface AppDAO {

	void save(Instructor theInstructor);

	Instructor findInstructorById(int theId);

	void deleteInstructor(int theId, String name);
}
