package com.nilesh.jersey.restweb;

import java.util.Date;
import java.util.List;

import javax.inject.Singleton;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.nilesh.jersey.DAO.EmployeeDAO;
import com.nilesh.jersey.pojo.Employee;
@Singleton
@Path("/emp")
public class EmployeeService {
	
	@GET @Path("/")
	 @Produces(MediaType.TEXT_PLAIN)
	    public String getStatus() {
	        return "working...";
	    }
	//http://localhost:8080/restweb/webapi/emp/list
	@GET @Path("/list")
	@Produces({"application/json", "application/xml"})
	public List<Employee> FindEmployee() {
		EmployeeDAO empDAO=new EmployeeDAO();
		return empDAO.getAllEmployee();
		
	}
	@GET @Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public int addEmployee(
			@QueryParam("name") String empName,
			@QueryParam("dept") String empDept,
			@QueryParam("sal") double salary,
			@QueryParam("mobile") long mobile,
			@QueryParam("email") String email){
		
		
		
		Employee emp=new Employee(0, empName, 
				empDept, salary, new Date(System.currentTimeMillis()),
				new Date(System.currentTimeMillis()), mobile, email);
	/*	Employee e=new Employee();
		e.setEmpName(empName);
		e.setEmpDepartment(empDept);
		e.setEmail(email);
		e.setEmpMobileNo(mobile);
		e.setSalary(salary);
		e.setId(empId);
		e.setDOB(new Date(System.currentTimeMillis()));
		e.setDOJ(new Date(System.currentTimeMillis()));*/
		EmployeeDAO empDAO=new EmployeeDAO();
		
		return empDAO.addEmployee(emp);
		
	}
	 
}
