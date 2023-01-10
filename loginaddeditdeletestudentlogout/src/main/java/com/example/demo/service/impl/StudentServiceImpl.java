package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepo;
import com.example.demo.model.Students;
import com.example.demo.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepo studentRepository;
	
	public StudentServiceImpl(StudentRepo studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Students> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Students saveStudent(Students student) {
		return studentRepository.save(student);
	}

	@Override
	public Students getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Students updateStudent(Students student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

}
