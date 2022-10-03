package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.common.Application;
import com.springmvc.model.MockupData;
import com.springmvc.model.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		
		
		// select options
		model.addAttribute("countries",MockupData.getCountries());
		
		// radio button
		model.addAttribute("languages",MockupData.getLanguages());
		// chat boxes
		model.addAttribute("operatingSystems",MockupData.getOS());
		return Application.STUDENT_FORM_PAGE;
	}
	@PostMapping("/processForm")
	//@ResponseBody // return json , show in interface
	public String process(
//			@RequestParam String fullName, // if concur name, if not necessary
//			@RequestParam("age") String ageAsString,
			@ModelAttribute ("student") Student student,
			Model model) {
		//1 get values {name, age} from Student form
		
		
		//2 save 
		//3 inform success registration to student form
//		model.addAttribute("fullName",fullName); // put data into new page (var, nowVar)
//		model.addAttribute("age",age);
		model.addAttribute("student",student);
		return Application.STUDENT_SUCCESS_PAGE;
	}
//	public String process(HttpServletRequest  request, Model model) {
//		//1 get values {name, age} from Student form
//		String fullName=  request.getParameter("fullName"); // get data from form student
//		int age=Integer.parseInt( request.getParameter("age"));
//		//2 save 
//		//3 inform success registration to student form
//		model.addAttribute("fullName",fullName); // put data into new page (var, nowVar)
//		model.addAttribute("age",age);
//		return Application.STUDENT_SUCCESS_PAGE;
//	}
	
}
