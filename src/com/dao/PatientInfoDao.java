package com.dao;

import com.model.PatientInfo;

public class PatientInfoDao {
	public boolean insert(PatientInfo patientInfo){
		return DatabaseOperation.insertOrUpdateOrDelete(
				"insert into PatientInfo values(?,?,?)", 
				patientInfo.getPatNo(),
				patientInfo.getPatName(),
				patientInfo.getPatType()
				)==1;
		
	}
}
