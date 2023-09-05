package com.jdc.mappings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.mappings.model.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseControllers {

	@Autowired
	private CourseService service;
	
	@GetMapping
	public String index(ModelMap model) {
		model.put("list", service.getAll());
		return "course-list";
	}
}
