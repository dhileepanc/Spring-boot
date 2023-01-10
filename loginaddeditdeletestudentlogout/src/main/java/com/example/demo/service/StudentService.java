package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Students;



public interface StudentService {
	List<Students> getAllStudents();
	
	Students saveStudent(Students student);
	
	Students getStudentById(Long id);
	
	Students updateStudent(Students student);
	
	void deleteStudentById(Long id);
}
