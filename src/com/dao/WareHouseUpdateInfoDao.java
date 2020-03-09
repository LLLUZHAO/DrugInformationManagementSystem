package com.dao;

import java.util.ArrayList;
import java.sql.Date;


import com.model.ManagerInfo;
import com.model.WareHouseUpdateInfo;

public class WareHouseUpdateInfoDao {

	public ArrayList<Object[]> selectAllBymanNo(String manNo) {
		return DatabaseOperation.select(
				"select * from WareHouseUpdateInfo where manNo=?",
				manNo);
	}
	public ArrayList<Object[]> selectAllBymanNo(ManagerInfo managerInfo) {
		return selectAllBymanNo(managerInfo.getManNo());
	}
	
	public Date to_Date(String string) {

		int year = 0;
		int month = 0;
		int day = 0;
		int num = 0;
		char chr;

		for (int i = 0; i < string.length(); i++) {
			chr = string.charAt(i);
			if (chr >= '0' && chr <= '9') {
				if (num < 4) {
					year = year * 10 + chr - '0';
				} else if (num < 6) {
					month = month * 10 + chr - '0';
				} else {
					day = day * 10 + chr - '0';
				}
				if (++num == 8) {
					break;
				}
			}
		}
		System.out.println(year+" "+month+" "+day);
		Date date=new Date(year-1900,month-1,day);
		return date;
	}

	public boolean Insert(WareHouseUpdateInfo wareHouseUpdateInfo) {
	
		return DatabaseOperation.insertOrUpdateOrDelete(
				"insert into WareHouseUpdateInfo values(?,?,?,?,?,?)",
				wareHouseUpdateInfo.getWarNo(),
				wareHouseUpdateInfo.getAddCount(),
				wareHouseUpdateInfo.getWarDate(),
				wareHouseUpdateInfo.getEndDate(),
				wareHouseUpdateInfo.getManNo(),
				wareHouseUpdateInfo.getMedNo()
				)==1;
	}

}
