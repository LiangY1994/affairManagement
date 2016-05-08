package com.util.bean;

public class Employee {
	private int employeeID;
	private String employeeName;
	private String employeePassword;
	private boolean isLead;
	public int getEmployeeID(){ // get ID
		return this.employeeID;
	}
	public void setEmployeeID(int employeeID){ // set ID
		this.employeeID = employeeID;
	}
	public String getEmployeePassword(){
		return this.employeePassword;
	}
	public void setEmployeePassword(String employeePassword){
		this.employeePassword = employeePassword;
	}
	public String getEmployeeName(){ // get Name
		return this.employeeName;
	}
	public void setEmployeeName(String employeeName){ // set Name
		this.employeeName = employeeName;
	}
	public boolean getIsLead(){ // get isLead
		return this.isLead;
	}
	public void setIsLead(boolean isLead){ // set isLead
		this.isLead = isLead;
	}
}
