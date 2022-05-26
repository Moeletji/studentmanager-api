package com.moeletji.studentmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moeletji.studentmanager.dto.StudentDTO;
import com.moeletji.studentmanager.exception.UserNotFoundException;
import com.moeletji.studentmanager.model.Enrolment;
import com.moeletji.studentmanager.model.Student;
import com.moeletji.studentmanager.repository.EnrolmentRepository;
import com.moeletji.studentmanager.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	private final EnrolmentRepository enrolmentRepository;
	
	@Autowired
	public UserService(UserRepository userRepository, EnrolmentRepository enrolmentRepository) {
		this.userRepository = userRepository;
		this.enrolmentRepository = enrolmentRepository;
	}
	
	public Student addUser(Student user) {
		user.setUserCode(UUID.randomUUID().toString());
		return userRepository.save(user);
	}
	
	public List<Student> findAllUsers() {
		return userRepository.findAll();
	}
	
	public Student updateUser(StudentDTO user) {
		Student savedUser = new Student();
		if (!user.equals(null)) {
			savedUser.setId(user.getId());
			savedUser.setName(user.getName());
			savedUser.setSurname(user.getSurname());
			savedUser.setJobTitle(user.getJobTitle());
			savedUser.setPhone(user.getPhone());
			savedUser.setEmail(user.getEmail());
			savedUser.setUserCode(user.getUserCode());
			savedUser.setImageUrl(user.getImageUrl());
			
			if (user.getCourses().size() > 0) {
				user.getCourses().forEach(course -> {
					Enrolment newEnrolment = new Enrolment(user.getId(), course);
					enrolmentRepository.save(newEnrolment);
				});
			}
		}
		
		return userRepository.save(savedUser);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteStudentById(id);
	}
	
	public Student findUserById(Long id) {
		return userRepository.findStudentById(id)
				.orElseThrow(()-> new UserNotFoundException("User with id " + id + " was not found"));
	}
}
