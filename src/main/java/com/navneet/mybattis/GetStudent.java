package com.navneet.mybattis;

public class GetStudent {

	private int collegeKey;
	private int rollNo;
	
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
	
	public GetStudent(int collegeKey, int rollNo) {
		this.collegeKey = collegeKey;
		this.rollNo = rollNo;
	}
	public GetStudent() {
		
	}
	
	
}
