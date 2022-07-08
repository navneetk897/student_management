package com.navneet.database;


import java.util.List;


import com.navneet.model.Student;

import com.navneet.mybattis.DataBaseService;


public class DataBase {
	
	DataBaseService dataBaseService;
	
	public DataBaseService getDataBaseService() {
		return dataBaseService;
	}

	public void setDataBaseService(DataBaseService dataBaseService) {
		this.dataBaseService = dataBaseService;
	}

	
	public List<Student> getAllStudent() {
		return dataBaseService.getAllStudent();
	}
	
	public Student getStudent(int rollNo) {
		return dataBaseService.getStudent(rollNo);
	}
	
	public void insertStudent(Student student) {
		dataBaseService.insertStudent(student);
	}
	
	public void deleteStudent(int rollNo) {
		dataBaseService.deleteStudent(rollNo);
	}
}
