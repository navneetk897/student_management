package com.navneet.mybattis;

import java.util.List;

import com.navneet.model.Student;

public class Main {

	public static void main(String[] args) {
		
		DataBaseService dataBaseService = new DataBaseService();
		//Student student = new Student(1, "Suraj", "computer-science", "TI", 87);
		List<Student> list = dataBaseService.getALLStudents(1);
		for (Student student : list) System.out.println(student);
	}

}
