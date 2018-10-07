package com.nilesh.jersey.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nilesh.jersey.pojo.Employee;
import com.nilesh.jersey.util.DBConnection;

public class EmployeeDAO {
	
	public EmployeeDAO() {}

	public int addEmployee(Employee e) {
		DBConnection DBconn=new DBConnection();
		Connection con=null;
		int result=0;
		try {
			con=DBconn.getDBConnection("root", "admin");
			if(con!=null) {
				Statement st=con.createStatement();
				String sql="insert into tb_Employee (empName,empDept,empMobile,empEmail,empSalary,empDOB,empDOJ) "
						+ "values('"+e.getEmpName()+"','"+e.getEmpDepartment()+"',"+e.getEmpMobileNo()+",'"+e.getEmail()+"',"
								+ ""+e.getSalary()+",now(),now());";
				result=st.executeUpdate(sql);

				if(st!=null)st.close();
			}else {
				result=-2;
				System.out.println("Fail To Creating mysql Connection");

			}
			
		}catch(Exception ex) {
			result=-1;
			System.out.println("Exception occured While Creating mysql Connection :: "+ex);


		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		}

		return result;	
	}
	public List<Employee> getAllEmployee() {
		DBConnection DBconn=new DBConnection();
		Connection con=null;
		List<Employee> empList=new ArrayList<>();
		Employee e=null;
		int result=0;
		try {
			con=DBconn.getDBConnection("root", "admin");
			if(con!=null) {
				Statement st=con.createStatement();
				String sql="select id,empName,empDept,empMobile,empEmail,empSalary,empDOB,empDOJ from tb_Employee;";
				ResultSet rs=st.executeQuery(sql);
				while(rs.next()){
					e=new Employee();
					e.setEmpName(rs.getString("empName"));
					e.setEmpDepartment(rs.getString("empDept"));
					e.setEmail(rs.getString("empEmail"));
					e.setEmpMobileNo(rs.getLong("empMobile"));
					e.setSalary(rs.getDouble("empSalary"));
					e.setId(rs.getInt("id"));
					e.setDOB(rs.getTimestamp("empDOB"));
					e.setDOJ(rs.getTimestamp("empDOJ"));
					empList.add(e);
					e=null;
					
				}
				if(rs!=null)rs=null;
				if(st!=null)st.close();

			}else {
				result=-2;
				System.out.println("Fail To Creating mysql Connection");

			}

		}catch(Exception ex) {
			result=-1;
			System.out.println("Exception occured While Creating mysql Connection :: "+ex);


		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		}

		return empList;	
	}
}
