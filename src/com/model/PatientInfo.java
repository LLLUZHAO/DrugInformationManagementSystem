package com.model;

import java.lang.reflect.Field;

public class PatientInfo {
	private String patNo;
	private String patName;
	private String patType;
	
	public PatientInfo(Object...objs){
		Field[] fields=this.getClass().getDeclaredFields();
		int len=Math.min(objs.length,fields.length);
		for(int i=0;i<len;i++){
			fields[i].setAccessible(true);
			try {
				fields[i].set(this,objs[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	public String getPatNo() {
		return patNo;
	}
	public void setPatNo(String patNo) {
		this.patNo = patNo;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getPatType() {
		return patType;
	}
	public void setPatType(String patType) {
		this.patType = patType;
	}
}
