package com.mindprove.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mindprove.Employedto.EmployeDTO;

public class EmployeService {

 public boolean save(EmployeDTO employeedto) {
	 
	 
		
		Connection con= null;
		PreparedStatement ps=null;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("load the driver successfully");
			
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emprecord","root","root");
			System.out.println("connection created successfully");
			
		ps=con.prepareStatement("INSERT INTO emptabel (name, email, phone, salary, designation, City) values (?,?,?,?,?,?)");	
		
		ps.setString(1, employeedto.getName());
		ps.setString(2, employeedto.getEmail());
		ps.setString(3, employeedto.getPhone());
		ps.setString(4, employeedto.getSalary());
		ps.setString(5, employeedto.getDesignation());
		ps.setString(6, employeedto.getCity());
		
	int row =ps.executeUpdate();
		
	
	return row>0;
		}
		catch(SQLException e) {
			
			e.printStackTrace();//chn		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	 return false; 
	 
 }	
 
 
 
	
}
