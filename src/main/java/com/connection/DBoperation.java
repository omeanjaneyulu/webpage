package com.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.sql.MysqlConnection;
import com.webcreation.bean.Encapsulation;

public class DBoperation {
	Connection connection;
	Statement statement;
	ResultSet result;
	
	public DBoperation() {
		connection = MysqlConnection.getInstance();
	}
	public int insertDataWithStatement(Encapsulation em) {
		int result = 0;
		String query = "insert into EmployeeBean values("+em.getEmployeeId()+",'"+em.getEmployeeName()+"','"+em.getFatherName()+"','"+em.getMobileNumber()+"','"+em.getEmailId()+"','"+em.getAddress()+"','"+em.getDob()+"')";
	
		try {
			statement = connection.createStatement();
			result = statement.executeUpdate(query);
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int deletedata(Encapsulation emp) {
		int result = 0;
		String query = "update EmployeeBean set id="+emp.getEmployeeId()+" where id= ";
		try {
		statement = connection.createStatement();
		result = statement.executeUpdate(query);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}