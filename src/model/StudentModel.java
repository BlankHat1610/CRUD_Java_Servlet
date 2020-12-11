/* 
 *	(C) Copyright 2020 LCN. All Rights Reserve
 *
 *	@author Admin
 *	@date Aug 26, 2020
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

import entities.Student;

public class StudentModel {
	static Connection connection = null;
	static Statement  stmt		  = null;
	static ResultSet  rs		  = null;
	static PreparedStatement preparedStatement = null;
	
	public static List<Student> getAllStudent() throws SQLException, ClassNotFoundException{
		List<Student> listStudent = new ArrayList<>();
		try {
			connection    = DBUtils.openConnection();
			stmt 		  = connection.createStatement();
			// execute the statement 
			rs = stmt.executeQuery("SELECT * FROM SinhVien");
			
			while(rs.next()) {
				String MaSV 		= rs.getString(1);
				String Hoten 		= rs.getString(2);
				String Gioitinh 	= rs.getString(3);
				String Dienthoai 	= rs.getString(4);
				String Email 		= rs.getString(5);
				String SV_MaLop 	= rs.getString(6);

				Student student = new Student(MaSV,Hoten,Gioitinh,Dienthoai,Email,SV_MaLop);
				listStudent.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listStudent;
	}
	
	public static boolean save(Student std) {
		boolean flag = false;
		try {
			String sql = " INSERT INTO SinhVien(MaSV,Hoten,Gioitinh,Dienthoai,Email,SV_MaLop) VALUES('"+std.getMaSV()+"', N'"+std.getHoTen()+"', "
					+ " N'"+std.getGioiTinh()+"', '"+std.getDienThoai()+"', '"+std.getEmail()+"', '"+std.getSv_Malop()+"') ";
			System.out.println(sql);
			connection = DBUtils.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}
	
	public static Student getSingleStudent(String id) {
		Student std = null;
		try {
			std = new Student();
			String sql   = " SELECT * FROM SinhVien WHERE MaSV='"+id+"' ";
			connection   = DBUtils.openConnection();
			stmt         = connection.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()) {
				String MaSV 		= rs.getString(1);
				String Hoten 		= rs.getString(2);
				String Gioitinh 	= rs.getString(3);
				String Dienthoai 	= rs.getString(4);
				String Email 		= rs.getString(5);
				String SV_MaLop 	= rs.getString(6);
				
				std.setMaSV(MaSV);
				std.setHoTen(Hoten);
				std.setGioiTinh(Gioitinh);
				std.setDienThoai(Dienthoai);
				std.setEmail(Email);
				std.setSv_Malop(SV_MaLop);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return std;
	}
	
	
	public static boolean updateStudent(Student std) {
		boolean flag = false;
		try{
			String sql = "UPDATE SinhVien SET Hoten=N'"+std.getHoTen()+"', Gioitinh=N'"+std.getGioiTinh()+"', "
					+ "Dienthoai='"+std.getDienThoai()+"', Email='"+std.getEmail()+"', SV_MaLop='"+std.getSv_Malop()+"' "
							+ "WHERE MaSV='"+std.getMaSV()+"'";
			System.out.println(sql);
			connection = DBUtils.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean idStudentExists(String id) {
		boolean flag = false;
		try {
			String sql   = "SELECT * FROM SinhVien";
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
	
	public static boolean deleteStudent(String id){
		boolean flag = false;
		try {
			String sql = "DELETE FROM SinhVien WHERE MaSV='"+id+"'";
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
