package com.DAO;

public class EmployeeDAOFactory {
	public static EmployeeDAO getEmployeeDAOInstance(){
		return new EmployeeDAOImpl();	// return an example of EmployeeDAO
	}
}
