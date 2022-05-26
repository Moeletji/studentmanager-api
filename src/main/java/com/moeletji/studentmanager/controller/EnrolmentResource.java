package com.moeletji.studentmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moeletji.studentmanager.model.Enrolment;
import com.moeletji.studentmanager.service.EnrolmentService;

@RestController
@RequestMapping("/enrolment")
public class EnrolmentResource {
	
	private final EnrolmentService enrolmentService;
	
	public EnrolmentResource(EnrolmentService enrolmentService) {
		this.enrolmentService = enrolmentService;
	}
	
	@GetMapping("/find/{userId}")
	public ResponseEntity<List<Enrolment>> getUserById(@PathVariable("userId") Long userId) {
		List<Enrolment> enrolments = enrolmentService.findEnrolmentByUserId(userId);
		return new ResponseEntity<List<Enrolment>>(enrolments, HttpStatus.OK);
	}
}
