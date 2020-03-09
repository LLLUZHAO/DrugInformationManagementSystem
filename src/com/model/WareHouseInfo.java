package com.model;

import java.lang.reflect.Field;
import java.sql.Date;

public class WareHouseInfo {

	private String medNo;
	private int warCount;
	private Date endDate;

	
	public WareHouseInfo(Object...objs){
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
	
	public int getWarCount() {
		return warCount;
	}
	public void setWarCount(int warCount) {
		this.warCount = warCount;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMedNo() {
		return medNo;
	}
	public void setMedNo(String medNo) {
		this.medNo = medNo;
	}
	
	
}
