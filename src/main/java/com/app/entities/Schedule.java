package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Schedule extends BaseEntity{
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	@NotBlank(message = "Location is required")
	private String location;

	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonIgnore
	private Course course;

	@ManyToOne
	@JoinColumn(name="subject_id")
	@JsonIgnore
	private Subject subject;

	public Schedule() {
	}

	public Schedule(LocalDateTime startTime,
			LocalDateTime endTime,
			@NotBlank(message = "Location is required") String location, Course course, Subject subject) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.course = course;
		this.subject = subject;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Schedule [startTime=" + startTime + ", endTime=" + endTime + ", location=" + location + "]";
	}	
}
