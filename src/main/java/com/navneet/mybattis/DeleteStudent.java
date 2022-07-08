package com.navneet.mybattis;

public class DeleteStudent {
	
	private int collegeKey;
	private int rollNo;
	
	public DeleteStudent(int collegeKey, int rollNo) {
		super();
		this.collegeKey = collegeKey;
		this.rollNo = rollNo;
	}
	
	public DeleteStudent() {
		
	}
	
	public int getCollegeKey() {
		return collegeKey;
	}
	
	public void setCollegeKey(int collegeKey) {
		this.collegeKey = collegeKey;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
}
