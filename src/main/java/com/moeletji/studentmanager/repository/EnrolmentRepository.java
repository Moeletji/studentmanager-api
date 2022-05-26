package com.moeletji.studentmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moeletji.studentmanager.model.Enrolment;

import java.util.Optional;
import java.util.List;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
	Optional<List<Enrolment>> findEnrolmentByUserId(Long userId);
}
