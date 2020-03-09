package com.model;

import java.lang.reflect.Field;
import java.sql.Date;

public class WareHouseUpdateInfo {

	private String warNo;//入库单号
	private int addCount;//入库数量
	private Date warDate;//入库时间
	private Date endDate;//终止日期
	private String manNo;//管理员
	private String medNo;//药品编号
	
	
	public WareHouseUpdateInfo(Object...objs){
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
	
	public String getWarNo(){
		return warNo;
	}
	public void setWarNo(String warNo){
		this.warNo=warNo;
	}
	
	
	public int getAddCount() {
		return addCount;
	}
	public void setAddCount(int addCount) {
		this.addCount = addCount;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getWarDate() {
		return warDate;
	}

	public void setWarDate(Date warDate) {
		this.warDate = warDate;
	}
	
	
	public String getMedNo(){
		return medNo;
	}
	public void setMedNo(String medNo){
		this.medNo=medNo;
	}
	
	public String getManNo(){
		return manNo;
	}
	public void setManNo(String manNo){
		this.manNo=manNo;
	}
}
