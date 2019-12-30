package com.sh.service;

import java.util.List;

import com.sh.Entity.Student;

public interface studentService {
	
	List<Student> getStudents();
	Student getStudent(int id);
	void deleteStudent(int id);
	void createStudent(Student stud);
	void updateStudent(Student stud);
	void createStudents(List<Student> students) ;
}
