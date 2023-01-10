package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Repository.StudentRepo;
import com.example.demo.model.Admin;
import com.example.demo.model.Students;
import com.example.demo.service.StudentService;






@Controller
public class MainController {
	
	private StudentService studentService;
	public MainController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Autowired
	private StudentRepo studentrepo;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	 public String getLoginForm()
	 {
		 return "signin";
	 }
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signin(@ModelAttribute(name="loginform")Admin admin, Model model)
	{
		String username=admin.getUsername();
		String password=admin.getPassword();
	if("admin1".equals(username) && "1234".equals(password)) {
		return "index";
	}
	model.addAttribute("invalidCredentials", true);
	return "signin";
	}
	@PostMapping("/logout")
	public String loggedout(Model model)
	{

		model.addAttribute("logs",model);
		return "signin";
	}
	
	/*
	 * @GetMapping("/attendance") public String addAttendance(Model model) {
	 * List<Students> liststudents = studentrepo.findAll();
	 * model.addAttribute("liststudents", liststudents); return "attendance"; }
	 * 
	 * @PostMapping("/radio") public String radio(Students student) {
	 * studentrepo.save(student); return "home"; }
	 */
	@PostMapping("/home")
	public String ListOfStudent(Students student) {
	
		
	studentrepo.save(student);
		
		return "home";
	}
	@GetMapping("/addstudent")
	public String addStudent(Model model)
	{
		model.addAttribute("students", new Students());
		
		return "addstudent";
	}

	@GetMapping("/viewstudent")
	public String listUsers(Model model) {
		List<Students> liststudents = studentrepo.findAll();
		model.addAttribute("liststudents", liststudents);
		
		return "viewstudent";
	}
	@GetMapping("/viewstudent/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/viewstudent/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Students student,
			Model model) {
		
		// get student from database by id
		Students existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setClass_(student.getClass_());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/viewstudent";		
	}
	
	// handler method to handle delete student request
	
	

	@GetMapping("/viewstudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/viewstudent";
	}
	
	
}
