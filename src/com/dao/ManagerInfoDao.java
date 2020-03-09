package com.dao;

import java.util.ArrayList;

import com.model.ManagerInfo;

public class ManagerInfoDao {
	public boolean initByManNo(ManagerInfo managerInfo) {
		String sql = "select pw,authority from ManagerInfo where manNo = ? ";
		ArrayList<Object[]> object = DatabaseOperation.select(sql,
				managerInfo.getManNo());
		if (object.size() <= 1) {
			return false;
		} else {
			managerInfo.setPw(String.valueOf(object.get(1)[0]));
			managerInfo.setAuthority(Integer.valueOf(String.valueOf(object
					.get(1)[1])));
			return true;
		}
	}

	public ArrayList<Object[]> selectAll() {
		String sql = "select * from ManagerInfo where authority<>0";
		return DatabaseOperation.select(sql);
	}
	public ArrayList<Object[]> selectUserAndAuthority() {
		String sql = "select manNo,authority from ManagerInfo where authority<>0";
		return DatabaseOperation.select(sql);
	}
	
	public boolean insert(ManagerInfo managerInfo){
		return DatabaseOperation.insertOrUpdateOrDelete(
				"insert into ManagerInfo values(?,?,?)",
				managerInfo.getManNo(),
				managerInfo.getPw(),
				managerInfo.getAuthority()
				)==1;
	}
	
	public boolean deleteByManNo(String ManNo){
		return DatabaseOperation.insertOrUpdateOrDelete(
				"delete from ManagerInfo where manNo=?",
				ManNo
				)==1;
	}
	public boolean deleteByManNo(ManagerInfo managerInfo){
		return deleteByManNo(managerInfo.getManNo());
	}
	public Integer selectAuthorityByManNo(String ManNo){
		String sql="select authority from ManagerInfo where manNo=?";
		ArrayList<Object[]> resultList=DatabaseOperation.select(sql,ManNo);
		
		if(resultList.size()>1){
			return Integer.valueOf(String.valueOf(resultList.get(1)[0]));
		}else{
			return -1;
		}
	}
	public Integer selectAuthorityByManNo(ManagerInfo managerInfo){
		return selectAuthorityByManNo(managerInfo.getManNo());

	}
}
