package com.resttestapi.resttestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resttestapi.resttestapi.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
