package com.moeletji.studentmanager.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;



@Entity
public class Enrolment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	private long userId;
	private long courseId;
	
	@CreationTimestamp
	private Timestamp date;
	
	public Enrolment() {
		
	}

	public Enrolment(long l, long courseId) {
		super();
		this.userId = l;
		this.courseId = courseId;
	}
	
	public Enrolment(long id, long userId, long courseId, Timestamp date) {
		super();
		this.id = id;
		this.userId = userId;
		this.courseId = courseId;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
