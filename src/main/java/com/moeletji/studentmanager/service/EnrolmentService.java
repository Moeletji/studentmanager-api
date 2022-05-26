package com.moeletji.studentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moeletji.studentmanager.exception.UserNotFoundException;
import com.moeletji.studentmanager.model.Enrolment;
import com.moeletji.studentmanager.repository.EnrolmentRepository;
import java.util.List;

@Service
@Transactional
public class EnrolmentService {
	
	private final EnrolmentRepository enrolmentRepository;
	
	@Autowired
	public EnrolmentService(EnrolmentRepository enrolmentRepository) {
		this.enrolmentRepository = enrolmentRepository;
	}
	
	public List<Enrolment> findEnrolmentByUserId(Long userId) {
		return enrolmentRepository.findEnrolmentByUserId(userId)
				.orElseThrow(()-> new UserNotFoundException("Enrolment with userId " + userId + " was not found"));
	}
}
