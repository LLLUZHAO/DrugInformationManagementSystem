package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
//增删改查
public class DatabaseOperation {
	//增删改
	//传入完整的sql语句，返回修改的行数
	public static int insertOrUpdateOrDelete(String sql,Object...values){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs;
		System.out.println(sql);
		for(int i=0;i<values.length;i++){
			System.out.println(values[i]);
		}
		try{
			conn = DButil.getConnection();
			pstmt =  conn.prepareStatement(sql);
			for(int i=0;i<values.length;i++){
				pstmt.setObject(i+1,values[i]);
			}
			rs =   pstmt.executeUpdate();//执行sql,该方法返回一个整数，用于表示sql影响的行数
		}catch (SQLException e) {
			e.printStackTrace();
			rs=-1;
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	//查
	/*
	 * 
	 * 具体参考下面的main函数
	 */
	public static ArrayList<Object[]> fuzzySelect(String sql,Object...values){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//用于存储查询结果
		ArrayList<Object[]> tableData = new ArrayList<Object[]>();
		Object[] result = null;
		try{
			conn = DButil.getConnection();
			/*
			System.out.println(sql);
			for(int i=0;i<values.length;i++){
				System.out.println(values[i]);
			}*/
			pstmt =  conn.prepareStatement(sql);
			
			//根据第二个参数，循环将values数组中的值，传递给sql的?号占位符
			for(int i=0;i<values.length;i++){
					pstmt.setObject(i+1, "%"+values[i]+"%");
				}
			ResultSet rs =   pstmt.executeQuery();//执行sql,该方法返回一个整数，用于表示sql影响的行数
			//ResultSet表示查询语句的结果集,可以调用rs.next()方法判断结果集中是否有下一条记录
			
			//元数据： 执行一条查询语句，可以获得数据库表中的记录
			//如果希望得到这条查询语句对应的表结构（列名称，列数据类型，长度,表名,列数）都可以通过元数据对象拿到
				
			ResultSetMetaData metaData =  rs.getMetaData();//由结果集的getMetaData得到元数据对象
			int columnCount =  metaData.getColumnCount();//获得查询结果的列数
			result = new Object[columnCount];
			for(int i =0;i<columnCount;i++){
				String columnName =  metaData.getColumnName(i+1);
				result[i] = columnName;
				//System.out.println((String)columnName);
			}
			tableData.add(result);
			
			while(rs.next()){//每循环一次取一行数据，将每一行数据按列名- 列值的形式存到HashMap中
				result = new Object[columnCount];
				//System.out.println(result);
				for(int i =0;i<columnCount;i++){
					//String columnName =  metaData.getColumnName(i+1);
					Object columnValue  =  rs.getObject(i+1);
					//result[k][i]=columnValue;
					result[i] = columnValue;
					//System.out.println(columnValue);
					//System.out.println(columnName+" "+columnValue);
				}
				tableData.add(result);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			tableData=null;
		}finally{
			/*
			try {
				//pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/		
		}
		return tableData;
	}
	
	public static ArrayList<Object[]> select(String sql,Object...values){
		Connection conn = null;
		PreparedStatement pstmt = null;
		//用于存储查询结果
		ArrayList<Object[]> tableData = new ArrayList<Object[]>();
		Object[] result = null;
		try{
			conn = DButil.getConnection();
			
			//System.out.println(sql);
			for(int i=0;i<values.length;i++){
				//System.out.println(values[i]);
			}
			pstmt =  conn.prepareStatement(sql);
			
			//根据第二个参数，循环将values数组中的值，传递给sql的?号占位符
			for(int i=0;i<values.length;i++){
					pstmt.setObject(i+1, values[i]);
				}
			ResultSet rs =   pstmt.executeQuery();//执行sql,该方法返回一个整数，用于表示sql影响的行数
			//ResultSet表示查询语句的结果集,可以调用rs.next()方法判断结果集中是否有下一条记录
			
			//元数据： 执行一条查询语句，可以获得数据库表中的记录
			//如果希望得到这条查询语句对应的表结构（列名称，列数据类型，长度,表名,列数）都可以通过元数据对象拿到
				
			ResultSetMetaData metaData =  rs.getMetaData();//由结果集的getMetaData得到元数据对象
			int columnCount =  metaData.getColumnCount();//获得查询结果的列数
			result = new Object[columnCount];
			
			for(int i =0;i<columnCount;i++){
				String columnName =  metaData.getColumnName(i+1);
				result[i] = columnName;
				//System.out.println((String)result[i]+(String)columnName);
			}
			tableData.add(result);
			
			while(rs.next()){//每循环一次取一行数据，将每一行数据按列名- 列值的形式存到HashMap中
				result = new Object[columnCount];
				for(int i =0;i<columnCount;i++){
					//String columnName =  metaData.getColumnName(i+1);
					Object columnValue  =  rs.getObject(i+1);
					//result[k][i]=columnValue;
					result[i] = columnValue;
					//System.out.println(columnName+" "+columnValue);
				}
				tableData.add(result);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			/*
			try {
				//pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/		
		}
		return tableData;
	}
	
	public static void main(String[] args) throws SQLException {
		
	}
}