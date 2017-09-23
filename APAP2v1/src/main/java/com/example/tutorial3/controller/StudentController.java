package com.example.tutorial3.controller;

import com.example.tutorial3.service.*;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tutorial3.service.*;
import com.example.tutorial3.model.*;

@Controller
public class StudentController {
	
	private final StudentService studentService;

	public StudentController() {
		//​studentService​ ​=​ ​new​ ​InMemoryStudentService​();
		studentService = new InMemoryStudentService();
	}
	
	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List<StudentModel> students = studentService.selectAllStudents();
		model.addAttribute("students", students);
//		view(model, "12345");
		return "viewall";
	}
	
	@RequestMapping("student/view")
	public String view (Model model, @RequestParam(value = "npm", required = true) String npm) {
		if (npm == null) return "error";
		StudentModel student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		return "view";
	}
	
	
	@RequestMapping(value = {"student/view/{npm}"})
	public String viewByNpm (@PathVariable Optional<String> npm, Model model) {
		if (npm.isPresent())
			return view(model, npm.get());
		else
			return "error";
	}
	
	@RequestMapping(value = {"student/delete/{npm}"})
	public String delete (@PathVariable Optional<String> npm, Model model) {
		if (!npm.isPresent())
			return "error";
		else {
			List<StudentModel> students = studentService.selectAllStudents();
			if (students.remove(new StudentModel(npm.get(), "", 0)))
				return "delete";
			else return "error";
		}
	}
	
	@RequestMapping("/student/add")
	public String add(
			@RequestParam(value = "npm", required = true) String npm,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "gpa", required = true) double gpa){
		StudentModel student = new StudentModel(npm, name, gpa);
		studentService.addStudent(student);
		return "add";
		
	}
	

}
