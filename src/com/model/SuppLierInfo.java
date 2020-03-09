package com.model;

import java.lang.reflect.Field;

public class SuppLierInfo {

	private String supNo;
	private String supName;
	private String supTel;
	
	public SuppLierInfo(Object...objs){
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
	
	public String getSupNo(){
		return supNo;
	}
	public void setSupNo(String supNo){
		this.supNo=supNo;
	}
	public String getSupName(){
		return supName;
	}
	public void setSupName(String supName){
		this.supName=supName;
	}
	public String getSupTel(){
		return supTel;
	}
	public void getSupTel(String supTel){
		this.supTel=supTel;
	}
	
}
