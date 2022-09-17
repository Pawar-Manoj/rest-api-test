package com.resttestapi.resttestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resttestapi.resttestapi.dao.CourseDao;
import com.resttestapi.resttestapi.entity.Course;
import com.resttestapi.resttestapi.repository.Myrepo;

@Service
public class MyServiceImpl implements MyServices{
	
	@Autowired
	CourseDao curseDao;
	
//	List<Course> courseList;
	public MyServiceImpl() {
		/*
		 * courseList= new ArrayList<>(); courseList.add(new Course(1,"JAva","JAVA"));
		 * courseList.add(new Course(2,"C","C")); courseList.add(new
		 * Course(3,"C++","C++")); courseList.add(new Course(4,"MK","MK"));
		 * courseList.add(new Course(5,"LOP","LOP")); courseList.add(new
		 * Course(6,"KOP","KOP")); courseList.add(new Course(7,"JKI","JKI"));
		 * courseList.add(new Course(8,"KIOL","LKIP"));
		 */	}
	public List<Course> getCourses(){
	//	return courseList;
		return curseDao.findAll();
	}
	@Override
	public Course getCoursesById(Long courseid) {
		return curseDao.getOne(courseid);
	}
	
	@Override
	public Course addCourses(Course course) {
		//courseList.add(course);
		return curseDao.save(course);
	}
	@Override
	public Course editCourses(Course course) {
		
		/*
		 * courseList.forEach(e ->{ if(e.getId() == course.getId()){
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription());}
		 * });
		 */
		return curseDao.save(course);
	}
	public void delCourses(Long course) {
		//courseList = courseList.stream().filter(e -> e.getId()!= course).collect(Collectors.toList());
		Course cur =curseDao.getOne(course);
		curseDao.delete(cur);
	}	

}
