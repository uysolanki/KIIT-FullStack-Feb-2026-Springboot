package com.kiit.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiit.lms.model.Student;
import com.kiit.lms.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	public void addStudent(Student s1) {
		studentRepository.save(s1);
		
	}
	public Student addStudent1(Student s1) {
		return studentRepository.save(s1);
	}

}
