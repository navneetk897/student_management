package com.navneet.mybattis;

import com.navneet.model.Student;

public class PutStudent {
	private int collegeKey;
	private Student student;
	
	public PutStudent(int collegeKey, Student student) {
		super();
		this.collegeKey = collegeKey;
		this.student = student;
	}
	
	public PutStudent() {
		
	}
	
	public int getCollegeKey() {
		return collegeKey;
	}
	
	public void setCollegeKey(int collegeKey) {
		this.collegeKey = collegeKey;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
