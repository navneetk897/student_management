package com.navneet.mybattis;

import java.io.IOException;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryService {
	private static SqlSessionFactory sessionFactory;
	
	private static SqlSessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Reader reader;
			try {
				reader = Resources.getResourceAsReader("batis.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				//sessionFactory.getConfiguration().addMapper(StudentMapper.class);
			}
			catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	public static SqlSession openSession() {
		return getSessionFactory().openSession();
	}
}
