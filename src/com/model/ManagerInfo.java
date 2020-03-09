package com.model;

import java.lang.reflect.Field;

//管理员信息
public class ManagerInfo {

	private String manNo;
	private String pw;
	private int authority;
	public ManagerInfo(Object...objs){
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int object) {
		this.authority = object;
	}
	
}
