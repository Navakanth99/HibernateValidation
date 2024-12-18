package com.Hibernate.HibernateValidation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Hibernate.HibernateValidation.entity.Student;
import com.Hibernate.HibernateValidation.repository.StudentRepository;

import jakarta.validation.Valid;

@RestController
public class StudentController {
    
	StudentRepository studentrepository;

	public StudentController(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Student> insert(@Valid @RequestBody Student student){
		
		Student savedstudent =studentrepository.save(student);
		return new ResponseEntity<>(savedstudent, HttpStatus.CREATED);
	}
}
