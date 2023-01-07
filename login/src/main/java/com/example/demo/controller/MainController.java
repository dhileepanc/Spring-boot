package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Repository.StudentRepo;
import com.example.demo.model.Admin;
import com.example.demo.model.Students;




@Controller
public class MainController {
	
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
		return "home";
	}
	model.addAttribute("invalidCredentials", true);
	return "signin";
	}
	
	@GetMapping("/addstudent")
	public String addStudent(Model model)
	{
		model.addAttribute("students", new Students());
		
		return "addstudent";
	}
	@PostMapping("/home")
	public String ListOfStudent(Students student) {
	
		
	studentrepo.save(student);
		
		return "home";
	}
	@GetMapping("/viewstudent")
	public String listUsers(Model model) {
		List<Students> liststudents = studentrepo.findAll();
		model.addAttribute("liststudents", liststudents);
		
		return "viewstudent";
	}
	@PostMapping("/logout")
	public String loggedout(Model model)
	{

		model.addAttribute(model);
		return "signin";
	}
	
}
