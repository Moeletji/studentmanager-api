package com.moeletji.studentmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moeletji.studentmanager.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	void deleteCourseById(Long id);

	Optional<Course> findCourseById(Long id);

}
