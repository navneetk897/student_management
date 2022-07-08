package com.navneet.service;

import java.util.List;




import com.navneet.model.Student;
import com.navneet.database.DataBase;

public class StudentService {
	
	private DataBase database;
	
	public DataBase getDatabase() {
		return database;
	}

	public void setDatabase(DataBase database) {
		this.database = database;
	}

	
	public List<Student> getAllStudent() {
		return database.getAllStudent();
	}
	
	public Student getStudent(int rollNo) {
		return database.getStudent(rollNo);
	}
	
	public void insertStudent(Student student) {
		database.insertStudent(student);
	}
	
	public void deleteStudent(int id) {
		database.deleteStudent(id);
	}
}
