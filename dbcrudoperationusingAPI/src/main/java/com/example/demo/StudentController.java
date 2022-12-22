package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	 @RequestMapping(value = "/students")
	   public List<Students> getAllStudents() 
	   {		
		return studentService.getAllStudents();
	   }	
	 
	 
	 @RequestMapping(value = "/students/{id}")
	 public Optional<Students> getStudent(@PathVariable Integer id) {
	 	return studentService.getStudent(id);
	 }
	 
	 
	 @RequestMapping(value = "/students", method=RequestMethod.POST)
	 public void addStudent(@RequestBody Students student) {
		 studentService.addStudent(student);
	 }
	 
	 @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	 public void updateStudent(@RequestBody Students student,@PathVariable Integer id ) {
		 studentService.updateStudent(id, student);
	 }
	 
	 @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	 public void deleteStudent(@PathVariable Integer id) {
		 studentService.deleteStudent(id);
	
}
}