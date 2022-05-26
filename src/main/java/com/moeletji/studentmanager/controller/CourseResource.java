package com.moeletji.studentmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moeletji.studentmanager.service.CourseService;
import com.moeletji.studentmanager.model.Course;

@RestController
@RequestMapping("/course")
public class CourseResource {
	
	private final CourseService courseService;
	
	public CourseResource(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Course>> getAllUsers() {
		List<Course> users = courseService.findAllCourses();
		return new ResponseEntity<List<Course>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Course> getUserById(@PathVariable("id") Long id) {
		Course course = courseService.findCourseById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Course> addUser(@Validated @RequestBody Course course) {
		Course newUser = courseService.addCourse(course);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Course> updateUser(@RequestBody Course course) {
		Course updatedUser = courseService.updateCourse(course);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		courseService.deleteCourse(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
