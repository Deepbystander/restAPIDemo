package com.bystandeep.demorestapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResources {

	StudentRespository repo = new StudentRespository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Student> getStudents() {
		
		return repo.getStudents();
		
	}
	
	@GET
	@Path("student/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student getStudent(@PathParam("id") int id) {
		return repo.getStudent(id);
		
	}
	
	@POST
	@Path("insert")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student createStudent(Student s1) {		
		repo.create(s1);
		return s1;
	}
	
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student updateStudent(Student s1) {
		
		if(repo.getStudent(s1.getId()).getId()==0) {
			repo.create(s1);
		}
		else {
			repo.update(s1);
		}
		return s1;
	}
	
	@DELETE
	@Path("delete/{id}")
	public Student deleteStudent(@PathParam("id") int id) {
		
		Student s = repo.getStudent(id);
		if(s.getId()!=0)
			repo.deleteStudent(id);
		return s;
	}
	
}
