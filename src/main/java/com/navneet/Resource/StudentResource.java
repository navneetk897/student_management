package com.navneet.Resource;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.navneet.model.Student;
import com.navneet.mybattis.DataBaseService;

@Path("studentResource")
public class StudentResource {
	
	private DataBaseService dataBaseService;
	
	public DataBaseService getDataBaseService() {
		return dataBaseService;
	}

	public void setDataBaseService(DataBaseService dataBaseService) {
		this.dataBaseService = dataBaseService;
	}


	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudent(@HeaderParam("username") String userName, @HeaderParam("password") String password) {
		int collegeKey = dataBaseService.getCollegeKey(userName, password);
		if (collegeKey == -1) {
			return Response.status(403).entity("Invalid user credential").build();
		}
		List<Student> list = dataBaseService.getALLStudents(collegeKey);
		if (list.size() == 0) {
			return Response.status(403).entity("No student data available").build();
		}
		GenericEntity<List<Student>> en = new GenericEntity<List<Student>>(list){};
		return Response.status(200).entity(en).build();
	}
	
	@GET
	@Path("/get/{rollNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@HeaderParam("username") String userName, @HeaderParam("password") String password,
			@PathParam("rollNo") int rollNo) {
		int collegeKey = dataBaseService.getCollegeKey(userName, password);
		if (collegeKey == -1) {
			return Response.status(403).entity("Invalid user credential").build();
		}
		Student student = dataBaseService.getStudent(collegeKey, rollNo);
		if (student == null) {
			return Response.status(403).entity("No data available for this student").build();
		}
		return Response.status(200).entity(student).build();
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student,
			@HeaderParam("username") String userName, @HeaderParam("password") String password) {
		 int collegeKey = dataBaseService.getCollegeKey(userName, password);
		 if (collegeKey == -1) {
			 return Response.status(403).entity("Invalid user credential").build();
		 }
		 boolean isInserted = dataBaseService.insertStudent(student, collegeKey);
		 if (isInserted) {
			 return Response.status(201).entity("Student data inserted").build();
		 }
		 return Response.status(409).entity("Student with this roll number already exists").build();
	}
	
	@DELETE
	@Path("/delete/{rollNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@HeaderParam("username") String userName, @HeaderParam("password") String password,
			@PathParam("rollNo") int rollNo) {
		int collegeKey = dataBaseService.getCollegeKey(userName, password);
		if (collegeKey == -1) {
			return Response.status(403).entity("Invalid user credential").build();
		}
		boolean isDeleted = dataBaseService.deleteStudent(rollNo, collegeKey);
		if (isDeleted) {
			return Response.status(200).entity("Student data deleted successfully").build();
		}
		return Response.status(200).entity("Student data doesn't exits").build();
	}
}