package com.resttestapi.resttestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resttestapi.resttestapi.entity.Course;
import com.resttestapi.resttestapi.service.MyServiceImpl;
import com.resttestapi.resttestapi.service.MyServices;

@RestController
@RequestMapping("/my")
public class MyController {
	
	@Autowired
	MyServices myservice;
	
	@GetMapping("/msg")
	public String msg() {
		return "Hello";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return  myservice.getCourses();
	}
	
	@GetMapping("/courses/{courseid}")
	public Course getCoursesById(@PathVariable Long courseid){
		return  myservice.getCoursesById(courseid);
	}
	
	@PostMapping("/courses/add")
	public Course addCourses(@RequestBody Course course){
		return  myservice.addCourses(course);
	}


	@PutMapping("/courses/edit")
	public Course editCoursesById(@RequestBody Course course){
		return  myservice.editCourses(course);
	}
	
	@DeleteMapping("/courses/del/{courseid}")
	public ResponseEntity<HttpStatus> delCourses(@PathVariable String courseid){
		try {
		myservice.delCourses(Long.parseLong(courseid));
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
}
