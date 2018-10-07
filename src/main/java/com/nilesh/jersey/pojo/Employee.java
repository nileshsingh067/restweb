package com.nilesh.jersey.pojo;

import java.util.Date;

public class Employee {

	private int id;
	private String empName;
	private String empDepartment;
	private double salary;
	private Date DOB;
	private Date DOJ;
	private long empMobileNo;
	private String email;
	
	
	
	
	public Employee() {}
	public Employee(int id, String empName, String empDepartment, double salary, Date dOB, Date dOJ, long empMobileNo,
			String email) {
		super();
		this.id = id;
		this.empName = empName;
		this.empDepartment = empDepartment;
		this.salary = salary;
		DOB = dOB;
		DOJ = dOJ;
		this.empMobileNo = empMobileNo;
		this.email = email;
	}
	public long getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(long empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Date getDOJ() {
		return DOJ;
	}
	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empDepartment=" + empDepartment + ", salary=" + salary
				+ ", DOB=" + DOB + ", DOJ=" + DOJ + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOB == null) ? 0 : DOB.hashCode());
		result = prime * result + ((DOJ == null) ? 0 : DOJ.hashCode());
		result = prime * result + ((empDepartment == null) ? 0 : empDepartment.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;
		if (DOJ == null) {
			if (other.DOJ != null)
				return false;
		} else if (!DOJ.equals(other.DOJ))
			return false;
		if (empDepartment == null) {
			if (other.empDepartment != null)
				return false;
		} else if (!empDepartment.equals(other.empDepartment))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	
	
	

}
