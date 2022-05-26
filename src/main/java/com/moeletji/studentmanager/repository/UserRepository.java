package com.moeletji.studentmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moeletji.studentmanager.model.Student;

@Repository
public interface UserRepository extends JpaRepository<Student, Long> {

	void deleteStudentById(Long id);

	Optional<Student> findStudentById(Long id);

}
