package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.entity.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("recipient", "World");
        return "index1";
    }
	@RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudents(Model model) {
		List<Student> students = new ArrayList<Student>();
		// logic to build student data
		
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Name 1");
		students.add(student1);
		
		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Name 2");
		students.add(student2);
		
		model.addAttribute("students", students);
        model.addAttribute("recipient", "World");
        return "students";
    }

}
