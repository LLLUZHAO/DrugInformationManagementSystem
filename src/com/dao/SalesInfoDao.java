package com.dao;

import java.util.ArrayList;

import com.model.ManagerInfo;
import com.model.MedicineInfo;
import com.model.SalesInfo;

public class SalesInfoDao {

	
	public ArrayList<Object[]> selectAllBymanNo(String ManNo){		
		return DatabaseOperation.select("select * from SalesInfo where manNo=?",ManNo);
	}
	
	public ArrayList<Object[]> selectAllBymanNo(ManagerInfo managerInfo){
		return selectAllBymanNo(managerInfo.getManNo());	
	}
	
	public boolean insert(SalesInfo salesInfo){
		
		int warCount=new WareHouseInfoDao().getWarCountbyMedNo(new MedicineInfo(salesInfo.getMedNo()));
		if(salesInfo.getSalCount()>warCount){
			return false;
		}
		else{
			return DatabaseOperation.insertOrUpdateOrDelete(
					"insert into SalesInfo values(?,?,?,?,?,?)",
					salesInfo.getSalNo(),
					salesInfo.getPatNo(),
					salesInfo.getMedNo(),
					salesInfo.getSalCount(),
					salesInfo.getSalDate(),
					salesInfo.getManNo()
					)==1;
		}
	}
	
}
