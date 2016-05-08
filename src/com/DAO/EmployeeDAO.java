package com.DAO;

import java.util.List;
import com.util.bean.*;

public interface EmployeeDAO {
	public void addEmployee(Employee p); // add an employee
	public void updateEmployee(Employee p, int employeeID); // update the information of an employee
	public void deleteEmployee(int employeeID); // delete an employee by ID
	public Employee findEmployee(int employeeID); // find an employee by ID
	public List<Employee> findAllEmployee(); // find all employees
}
