package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sql.MysqlConnection;
import com.webcreation.bean.Encapsulation;


public class DBoperation {
	Connection connection;
	Statement statement;
	PreparedStatement pstate;
	ResultSet resultset;
	
	public DBoperation() {
		connection = MysqlConnection.getInstance();
	}
	public int insertDataWithStatement(Encapsulation ec) {
		int result = 0;
		String query = "insert into encapsulation values(?,?,?,?,?,?,?)";	
		try {
			pstate = connection.prepareStatement(query);
			pstate.setString(1,ec.getEmployeeId() );
			pstate.setString(2, ec.getEmployeeName());
			pstate.setString(3,ec.getFatherName());
			pstate.setString(4, ec.getMobileNumber());
			pstate.setString(5, ec.getEmailId());
			pstate.setString(6, ec.getAddress());
			pstate.setString(7, ec.getDob());
		
			result = pstate.executeUpdate();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return result;
		
	}
	
	public int deletedata(Encapsulation emp) {
		int result = 0;
		String query = "Delete from Encapsulation where Employeeid= '"+emp.getEmployeeId()+"' ;";
		try {
		statement = connection.createStatement();
		result = statement.executeUpdate(query);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int UpdateDataWithStatement(Encapsulation ec) {
		int result = 0;
		String query = "Update encapsulation set EmployeeName= ?, mobileNumber= ?, emailId= ?, Address= ? where EmployeeId = '"+ec.getEmployeeId()+"';"; 
		try {
			 pstate = connection.prepareStatement(query);
			
			pstate.setString(1, ec.getEmployeeName());
			
			pstate.setString(2, ec.getMobileNumber());
			pstate.setString(3, ec.getEmailId());
			pstate.setString(4, ec.getAddress());
			//pstate.setString(5,ec.getEmployeeId() );
		
			result = pstate.executeUpdate();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return result;
		
	}
	public Encapsulation Searchst(String ec) {
		Encapsulation result = null;
		String query = "select * from encapsulation where EmployeeId = ?";
		try {
		pstate = connection.prepareStatement(query);
		pstate.setString(1,ec);
		resultset = pstate.executeQuery();
		while(resultset.next()) {
		result = new Encapsulation();
		result.setEmployeeId(resultset.getString(1));
		result.setEmployeeName(resultset.getString(2));
		result.setFatherName(resultset.getString(3));
		result.setMobileNumber(resultset.getString(4));
		result.setEmailId(resultset.getString(5));
		result.setAddress(resultset.getString(6));
		result.setDob(resultset.getString(7));
		}

		}

		catch (SQLException e) {
		e.printStackTrace();
		}
		return result;
		}

	public List< Encapsulation >Fetch() {
		Encapsulation result = null;
		List<Encapsulation> listofemp = new ArrayList<Encapsulation>();

		String query = "select * from encapsulation";
		try {
		pstate = connection.prepareStatement(query);
				resultset = pstate.executeQuery();
		while(resultset.next()) {
		result = new Encapsulation();
		result.setEmployeeId(resultset.getString(1));
		result.setEmployeeName(resultset.getString(2));
		result.setFatherName(resultset.getString(3));
		result.setMobileNumber(resultset.getString(4));
		result.setEmailId(resultset.getString(5));
		result.setAddress(resultset.getString(6));
		result.setDob(resultset.getString(7));
		listofemp.add(result);
		}

		}

		catch (SQLException e) {
		e.printStackTrace();
		}
		return listofemp;
		}
	


}