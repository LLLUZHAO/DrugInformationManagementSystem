package com.dao;

import java.util.ArrayList;

import com.model.MedicineInfo;

public class WareHouseInfoDao {
	
	public int getWarCountbyMedNo(String MedNo){
		String sql="select sum(WarCount) from WareHouseInfo where medNo=?";
		ArrayList<Object[]> arrayList=DatabaseOperation.select(sql,MedNo);
		if(arrayList.size()<=1){
			return -1;
		}else{
			return Integer.valueOf(String.valueOf(arrayList.get(1)[0]));
		}
	}
	
	public int getWarCountbyMedNo(MedicineInfo medicineInfo){
		return getWarCountbyMedNo(medicineInfo.getMedNo());
	}
	public  ArrayList<Object[]> fuzzySelectByMedNo(String medNo){
		String sql="select * from WareHouseInfo where medNo like ?";
		return DatabaseOperation.fuzzySelect(sql,medNo);
	}
	public  ArrayList<Object[]> fuzzySelectByMedNo(MedicineInfo medicineInfo){
		return fuzzySelectByMedNo(medicineInfo.getMedNo());
	}
	
}
