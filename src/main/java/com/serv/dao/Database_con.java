package com.serv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database_con  {
	String url="jdbc:mysql://localhost:3306/temp1";
	String pass1="adarsh@123";
	String user="root";
	static String diver="com.mysql.cj.jdbc.Driver";
	
	static {
		try{
			Class.forName(diver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean varifyUser(String name,String pass){
		
		String query="SELECT name, pass from t11 where name=? and pass=?";
		 
		try(Connection con=DriverManager.getConnection(url,user,pass1);
			PreparedStatement ps=con.prepareStatement(query);) {
			
			ps.setString(1, name);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			
			return rs.next();
			 
		} catch (SQLException e) {
			System.out.println("Gadbad database.. varify user");
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	public boolean register(String name,String pass ,String email){
		
		String query="insert into t11(email,name,pass) value(?,?,?)";
		 
		try(Connection con=DriverManager.getConnection(url,user,pass1);
			PreparedStatement ps=con.prepareStatement(query);) {
			
			ps.setString(1, email);
			ps.setString(2,name);
			ps.setString(3,pass);
			
			int rs=-1;
			try {
			 rs=ps.executeUpdate();
			}catch(SQLException e){
				System.out.println("Entering duplicate entry");
			}
		    System.out.println(rs+" is result set value");
		    if(rs!=-1)
		    	return true;
			return false;
			 
		} catch (SQLException e) {
			System.out.println("Gadbad database.. register");
			e.printStackTrace();
		}
		
		
		return false;
	}
	

}
