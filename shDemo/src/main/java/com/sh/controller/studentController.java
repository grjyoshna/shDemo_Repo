package com.sh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.Entity.Student;
import com.sh.service.studentServiceImpl;

@RestController
@RequestMapping("/students")
public class studentController {
	@Autowired
	private studentServiceImpl service;
	
	@GetMapping("/getAll")
	public List<Student> getStudents()
	{
		return service.getStudents();
	}
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable int id)
	{
		return service.getStudent(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id)
	{
		System.out.println("Start of delete");
		service.deleteStudent(id);
		System.out.println("Done!");
	}
	
	@PostMapping("/create")
	public void createStudent(@RequestBody Student stud)
	{
		stud.setId(0);
		System.out.println("Start of add student");
		service.createStudent(stud);
		System.out.println("Done!");
	}
	
	
	
	@PutMapping("/update")
	public void updateStudent(@RequestBody Student stud)
	{
		
		System.out.println("Start of update student");
		service.updateStudent(stud);
		System.out.println("Done!");
	}
	
	

}
