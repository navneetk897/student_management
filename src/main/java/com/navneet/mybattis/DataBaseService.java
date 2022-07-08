package com.navneet.mybattis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.navneet.model.Student;

public class DataBaseService {
	
	public List<Student> getALLStudents(int collegeKey) {
		SqlSession session = SessionFactoryService.openSession();
		List<Student> list = session.selectList("getAllStudent", collegeKey);
		session.close();
		return list;
	}
	
	public Student getStudent(int college_key, int rollNo) {
		SqlSession session = SessionFactoryService.openSession();
		GetStudent getStudent = new GetStudent(college_key, rollNo);
		Student student = session.selectOne("getStudentRollNo", getStudent);
		session.close();
		return student;
	}
	public boolean insertStudent(Student student, int collegeKey) {
		Student stu = getStudent(collegeKey, student.getRollNo());
		if (stu != null) return false;
		SqlSession session = SessionFactoryService.openSession();
		PutStudent putStudent = new PutStudent(collegeKey, student);
		session.insert("insertStudent", putStudent);
		session.commit();
		session.close();
		return true;
	}
	
	public boolean deleteStudent(int rollNo, int collegeKey) {
		Student stu = getStudent(collegeKey, rollNo);
		if (stu == null) return false;
		SqlSession session = SessionFactoryService.openSession();
		DeleteStudent deleteStudent = new DeleteStudent(collegeKey, rollNo);
		session.delete("removeStudent", deleteStudent);
		session.commit();
		session.close();
		return true;
	}
	
	public int getCollegeKey(String userName, String password) {
		SqlSession session = SessionFactoryService.openSession();
		GetUser getUser = new GetUser(userName, password);
		Integer collegeKey = session.selectOne("getCollegeKey", getUser);
		if (collegeKey == null) collegeKey = -1;
		session.close();
		return collegeKey;
	}
}

