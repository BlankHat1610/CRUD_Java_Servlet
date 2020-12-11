/* 
 *	(C) Copyright 2020 LCN. All Rights Reserve
 *
 *	@author Admin
 *	@date Aug 27, 2020
 *	@version 1.0
 */ 
package entities;

public class Class {
	private String malop, gvcn, nganh;

	public Class() {
		super();
	}
	
	public Class(String malop, String gvcn, String nganh) {
		super();
		this.malop = malop;
		this.gvcn = gvcn;
		this.nganh = nganh;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getGvcn() {
		return gvcn;
	}

	public void setGvcn(String gvcn) {
		this.gvcn = gvcn;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	@Override
	public String toString() {
		return "Class [malop=" + malop + ", gvcn=" + gvcn + ", nganh=" + nganh + "]";
	}
}
