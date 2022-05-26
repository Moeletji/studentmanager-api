package com.moeletji.studentmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moeletji.studentmanager.exception.UserNotFoundException;
import com.moeletji.studentmanager.model.Course;
import com.moeletji.studentmanager.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	
	private final CourseRepository courseRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public List<Course> findAllCourses() {
		return courseRepository.findAll();
	}
	
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public void deleteCourse(Long id) {
		courseRepository.deleteCourseById(id);
	}
	
	public Course findCourseById(Long id) {
		return courseRepository.findCourseById(id)
				.orElseThrow(()-> new UserNotFoundException("User with id " + id + " was not found"));
	}
}
