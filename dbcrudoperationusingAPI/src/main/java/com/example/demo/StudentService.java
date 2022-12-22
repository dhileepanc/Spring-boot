package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository;

	public List<Students> getAllStudents() {
		
	    List<Students> students = new ArrayList<>();
		
	    studentRepository.findAll()
	    .forEach(students::add);
		
	    return students;	
	}
	public void addStudent(Students student) {
	     studentRepository.save(student);
	}
	public Optional<Students> getStudent(Integer id) {
	     return studentRepository.findById(id);
	}
	public void updateStudent(Integer id, Students student) {
	     studentRepository.save(student);
	}
	public void deleteStudent(Integer id) {
	     studentRepository.deleteById(id);
	}
}
