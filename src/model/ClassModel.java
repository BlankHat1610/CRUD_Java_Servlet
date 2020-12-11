/* 
 *	(C) Copyright 2020 LCN. All Rights Reserve
 *
 *	@author Admin
 *	@date Aug 27, 2020
 *	@version 1.0
 */ 
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import entities.Class;
import entities.Student;

public class ClassModel {
	static Connection connection = null;
	static Statement  stmt		  = null;
	static ResultSet  rs		  = null;
	static PreparedStatement preparedStatement = null;
	
	public static List<Class> getAllClass() throws SQLException, ClassNotFoundException{
		List<Class> listClass = new ArrayList<>();
		try {
			connection    = DBUtils.openConnection();
			stmt 		  = connection.createStatement();
			// execute the statement 
			rs = stmt.executeQuery("SELECT * FROM Lop");
			
			while(rs.next()) {
				String MaLop 		= rs.getString(1);
				String Gvcn 		= rs.getString(2);
				String Nganh	 	= rs.getString(3);

				Class classes = new Class(MaLop, Gvcn, Nganh);
				listClass.add(classes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listClass;
	}
	
	public static boolean save(Class classes) {
		boolean flag = false;
		try {
			String sql = " INSERT INTO Lop(MaLop,Gvcn,Nganh) VALUES('"+classes.getMalop()+"', N'"+classes.getGvcn()+"', "
					+ " N'"+classes.getNganh()+"')";
			connection = DBUtils.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}
	
	public static Class getSingleClass(String id) {
		Class classes = null;
		try {
			classes = new Class();
			String sql   = " SELECT * FROM Lop WHERE MaLop='"+id+"' ";
			connection   = DBUtils.openConnection();
			stmt         = connection.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()) {
				String malop 		= rs.getString(1);
				String gvcn 		= rs.getString(2);
				String nganh		= rs.getString(3);
				
				classes.setMalop(malop);
				classes.setGvcn(gvcn);
				classes.setNganh(nganh);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return classes;
	}
	
	public static boolean idClassExists(String id) {
		boolean flag = false;
		try {
			String sql   = "SELECT * FROM Lop";
			connection   = DBUtils.openConnection();
			stmt         = connection.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString(1).equals(id)) {
					flag = true;
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateClass(Class classes) {
		boolean flag = false;
		try{
			String sql = "UPDATE Lop SET Gvcn=N'"+classes.getGvcn()+"', "
					+ "Nganh=N'"+classes.getNganh()+"' WHERE MaLop='"+classes.getMalop()+"'";
			connection = DBUtils.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
