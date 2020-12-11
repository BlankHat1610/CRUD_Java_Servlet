/* 
 *	(C) Copyright 2020 LCN. All Rights Reserve
 *
 *	@author Admin
 *	@date Aug 26, 2020
 *	@version 1.0
 */ 
package entities;

public class Student {
	private String maSV, hoTen, gioiTinh, dienThoai, email, sv_Malop;

	public Student() {
		super();
	}

	public Student(String maSV, String hoTen, String gioiTinh, String dienThoai, String email, String sv_Malop) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.dienThoai = dienThoai;
		this.email = email;
		this.sv_Malop = sv_Malop;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSv_Malop() {
		return sv_Malop;
	}

	public void setSv_Malop(String sv_Malop) {
		this.sv_Malop = sv_Malop;
	}

	@Override
	public String toString() {
		return "Student [maSV=" + maSV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", dienThoai=" + dienThoai
				+ ", email=" + email + ", sv_Malop=" + sv_Malop + "]";
	}	
}
