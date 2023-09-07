package com.jdc.mappings.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mappings.model.dto.Course;
import com.jdc.mappings.model.dto.Level;

@Service
public class CourseService {

	private List<Course> repo;
	
	@Autowired
	private CourseCodeGenerator codeGen;
	
	public CourseService() {
		repo = new ArrayList<Course>();
	}
	
	@PostConstruct
	public void init() {
		create(new Course("Java Basic", Level.Basic , 4 , 100000 ));
		create(new Course("Flutter" , Level.Intermediate , 4 , 150000));
		create(new Course("Spring Web" , Level.Intermediate , 3 , 200000));
		create(new Course("Spring Cloud" ,  Level.Advance , 5 , 2500000));
	}
	
	public int create(Course c) {
		var id = codeGen.next();
		c.setId(id);
		repo.add(c);
		return id;
	}
	
	public Course findById(int id) {
		return repo.stream().filter(c -> c.getId() == id).findAny().orElse(null);
	}
	
	public List<Course> getAll(){
		return List.copyOf(repo);
	}
}
