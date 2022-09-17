package com.resttestapi.resttestapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.resttestapi.resttestapi.entity.Course;

public interface MyServices {
	
	public List<Course> getCourses();

	public Course getCoursesById(Long courseid);


	public Course addCourses(Course course);

	public Course editCourses(Course course);

	public void delCourses(Long course);

}
