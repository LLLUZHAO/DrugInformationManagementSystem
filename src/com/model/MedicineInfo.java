package com.model;

import java.lang.reflect.Field;
import java.sql.Date;

public class MedicineInfo {

	private String medNo;
	private String medName;
	private String acceptNo;//国家
	private String medType;//剂型
	private String medCount;//规格
	private int useDate;//有效日期
	private String proName;//生产厂家
	public MedicineInfo(Object...objs){
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
	public int getUseDate() {
		return useDate;
	}
	public String getMedNo() {
		return medNo;
	}
	public void setMedNo(String medNo) {
		this.medNo = medNo;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getAcceptNo() {
		return acceptNo;
	}
	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}
	public String getMedType() {
		return medType;
	}
	public void setMedType(String medType) {
		this.medType = medType;
	}
	public String getMedCount() {
		return medCount;
	}
	public void setMedCount(String medCount) {
		this.medCount = medCount;
	}
	
	public void setUseDate(int useDate) {
		this.useDate = useDate;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
}
