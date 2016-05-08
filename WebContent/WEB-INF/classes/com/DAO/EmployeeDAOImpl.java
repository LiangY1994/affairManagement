package com.DAO;

import java.util.*;
import java.sql.*;
import com.util.DBConnection;
import com.util.bean.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	@Override
	public void addEmployee(Employee p) { // add an employee
		Connection conn = DBConnection.getConnection(); // get a connection object
		String addEmployeeSQL = "insert into tb_employee(employeeID, employeeName, employeePassword, isLead) "
								+ "values(?, ?, ?, ?)";
		PreparedStatement prstmt = null;
		try{
			prstmt = conn.prepareStatement(addEmployeeSQL); // get a prepared statement
			prstmt.setInt(1, p.getEmployeeID()); // set values
			prstmt.setString(2, p.getEmployeeName());
			prstmt.setString(3, p.getEmployeePassword());
			prstmt.setBoolean(4, p.getIsLead());
			prstmt.executeUpdate(); // execute query
		}catch(SQLException e){
			e.printStackTrace(); // sql exception
		}finally{
			DBConnection.closePreparedStatement(prstmt);
			DBConnection.closeConnection(conn);
		}
	}

	@Override
	public void updateEmployee(Employee p, int employeeID) {
		Connection conn = DBConnection.getConnection(); // get a new connection
		String updateEmployeeSQL = "update tb_employee set employeeName = ?, employeePassword = ?, isLead = ? where"
									+ " employeeID = ?";
		PreparedStatement prtsmt = null;
		try{
			prtsmt = conn.prepareStatement(updateEmployeeSQL); // get a new prepare sataement
			prtsmt.setString(1, p.getEmployeeName());
			prtsmt.setString(2, p.getEmployeePassword());
			prtsmt.setBoolean(3, p.getIsLead());
			prtsmt.setInt(4, employeeID);
			prtsmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace(); // sql exception
		}finally{
			DBConnection.closePreparedStatement(prtsmt);
			DBConnection.closeConnection(conn);
		}
	}

	@Override
	public void deleteEmployee(int employeeID) {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getConnection(); // get a new connection
		PreparedStatement prstmt = null;
		String deleteEmployeeSQL = "delete from tb_employee where "
				+ "employeeID = ?";
		try{
			prstmt = conn.prepareStatement(deleteEmployeeSQL);
			prstmt.setInt(1, employeeID);
			prstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.closePreparedStatement(prstmt);
			DBConnection.closeConnection(conn);
		}
	}

	@Override
	public Employee findEmployee(int employeeID) {
		// TODO Auto-generated method stub
		Employee p = null;
		Connection conn = DBConnection.getConnection(); // get a new connection
		PreparedStatement prstmt = null;
		ResultSet rst = null;
		String findEmployeeSQL = "select * from tb_employee where employeeID = ?";
		try{
			prstmt = conn.prepareStatement(findEmployeeSQL);
			prstmt.setInt(1, employeeID);
			rst = prstmt.executeQuery();
			if(rst.next()){
				p = new Employee();
				p.setEmployeeID(employeeID); // set informations of employee
				p.setEmployeeName(rst.getString(2));
				p.setEmployeePassword(rst.getString(3));
				p.setIsLead(rst.getBoolean(4));
			}
		}catch(SQLException e){
			e.printStackTrace(); // sql exception
		}finally{
			DBConnection.closeResultSet(rst);
			DBConnection.closePreparedStatement(prstmt);
			DBConnection.closeConnection(conn);
		}
		return p;
	}

	@SuppressWarnings("null")
	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employees = null;
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			String query = "select * from tb_employee order by employeeDate desc"; // initialization
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){ // find a employee correspond
				Employee employee = new Employee();
				employee.setEmployeeID(resultSet.getInt(1)); // set parameters
				employee.setEmployeeName(resultSet.getString(2));
				employee.setEmployeePassword(resultSet.getString(3));
				employees.add(employee); // add a employee into the list
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return employees;
	}
}
