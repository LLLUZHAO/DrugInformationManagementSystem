package com.dao;
import java.util.ArrayList;
import com.model.MedicineInfo;
public class MedicineInfoDao {

	public boolean insert(MedicineInfo medicineInfo){
		
		return DatabaseOperation.insertOrUpdateOrDelete(
				"insert into MedicineInfo values(?,?,?,?,?,?,?)",
				medicineInfo.getMedNo(),
				medicineInfo.getMedName(),
				medicineInfo.getAcceptNo(),
				medicineInfo.getMedType(),
				medicineInfo.getMedCount(),
				medicineInfo.getUseDate(),
				medicineInfo.getProName()
				)==1;
		
	}
	
	public ArrayList<Object[]> selectByMedNo(MedicineInfo medicineInfo){
		String sql="select * from MedicineInfo where medNo like ?";
		return  DatabaseOperation.fuzzySelect(sql,medicineInfo.getMedNo());
	}
	public ArrayList<Object[]> selectByMedNo(String medNo){
		String sql="select * from MedicineInfo where medNo like ?";
		return  DatabaseOperation.fuzzySelect(sql,medNo);
	}
	public ArrayList<Object[]> selectByMedName(MedicineInfo medicineInfo){
		String sql="select * from MedicineInfo where medName like ?";
		return  DatabaseOperation.fuzzySelect(sql,medicineInfo.getMedName());
	}
	public ArrayList<Object[]> selectByMedName(String medName){
		String sql="select * from MedicineInfo where medName like ?";
		return  DatabaseOperation.fuzzySelect(sql,medName);
	}	
}
