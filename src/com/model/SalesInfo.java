package com.model;

import java.lang.reflect.Field;
import java.sql.Date;

public class SalesInfo {

	private String salNo;//销售单号
	private String patNo;//患者编号
	private String medNo;//药品编号
	private int salCount;//销售数量
	private Date salDate;//销售时间
	private String manNo;//管理员
	
	public SalesInfo(Object...objs){
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
	
    public String getManNo() {
		return manNo;
	}

	public void setManNo(String manNo) {
		this.manNo = manNo;
	}

	public String getSalNo(){
		return salNo;
   	 
    }
    public void setSalNo(String salNo){
   	 this.salNo = salNo;
    }
    public String getPatNo(){
		return patNo;
    	 
     }
    public void setPatNo(String patNo){
   	 this.patNo = patNo;
    }
    public String getMedNo(){
		return medNo;
    	 
     }
    public void setMedNo(String medNo){
   	 this.medNo=medNo;
    }
    
	public int getSalCount() {
		return salCount;
	}
	public void setSalCount(int salCount) {
		this.salCount = salCount;
	}
	public Date getSalDate() {
		return salDate;
	}
	public void setSalDate(Date salDate) {
		this.salDate = salDate;
	}
    
}
