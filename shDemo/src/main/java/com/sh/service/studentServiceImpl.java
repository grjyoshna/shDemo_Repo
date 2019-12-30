package com.sh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.Dao.studentDaoImpl;
import com.sh.Entity.Student;
@Service
public class studentServiceImpl implements studentService{
	@Autowired
	private studentDaoImpl dao;

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		
		return dao.getStudents();
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		System.out.println("Service for delete is called");
		dao.deleteStudent(id);
	}

	@Override
	public void createStudent(Student stud) {
		// TODO Auto-generated method stub
		dao.createStudent(stud);
	}

	

	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return dao.getStudent(id);
	}

	public void updateStudent(Student stud) {
		// TODO Auto-generated method stub
		dao.updateStudent(stud);
	}

	public void createStudents(List<Student> students) {
		// TODO Auto-generated method stub
		dao.createStudents(students);
	}

}
