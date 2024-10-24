package com.example.CRUDOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDOperation.entity.Student;
import com.example.CRUDOperation.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repo;
	
	//get all student
	//htttp://localhost:8080/student
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		List<Student> students = repo.findAll();
		return students;
	}
	
	// http://localhost:8080/student/1
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}
	
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student =repo.findById(id).get();
		student.setName("rahul kadu");
		student.setPercentage(70);
		student.setBranch("mech");
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student =repo.findById(id).get();
		repo.delete(student);
	}
	
	
}
