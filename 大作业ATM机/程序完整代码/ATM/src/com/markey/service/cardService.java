package com.markey.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.markey.util.sqlHelper;

public class cardService {
//查询账号
	public boolean checkCardID(String cardID,String password){
		String sql="select * from hnxscard where cardId=? and password=?";
		String parameters[]={cardID,password};
		ResultSet rs=sqlHelper.executeQuery(sql,parameters);
		boolean result=false;
		try {
			if(rs.next()){
			   result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlHelper.close(rs,sqlHelper.getPs(),sqlHelper.getCt());
		}
		return result;
	}
//查询余额
public int checkNumber(String cardID){
		
        int result=0;		
		//使用sqlHelper来完成查询任务
		String sql="select number from hnxscard where cardId=?";
		String parameters[]={cardID};
		ResultSet rs=sqlHelper.executeQuery(sql, parameters);
		//根据rs来判断该用户是否存在,如果存在，则读取其余额
		try {
			if(rs.next()){
			    result=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlHelper.close(rs,sqlHelper.getPs(),sqlHelper.getCt());
		}
		return result;
}
//取款
public void getNumber(String cardID,int number){
	//调用数据库操作
	int result=0;
	result=this.checkNumber(cardID)-number;		
	String sql="update hnxscard set number=? where cardId=?";
	String parameters[]={String.valueOf(result),cardID};
	try {
		sqlHelper.executeUpdate(sql, parameters);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//存款
public void putNumber(String bankCard,String cardID,int number){
	//调用数据库操作
	int result=0;
	result=this.checkNumber(cardID)+number;		
	String sql="update "+bankCard+" set number=? where cardId=?";
	String parameters[]={String.valueOf(result),cardID};
	try {
		sqlHelper.executeUpdate(sql, parameters);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//查询密码
public String checkPassword(String cardID){
	String result=null;
	//使用sqlHelper来完成查询原密码
	String sql="select password from hnxscard where cardId=?";
	String parameters[]={cardID};
	ResultSet rs=sqlHelper.executeQuery(sql, parameters);
	//根据rs来判断该用户是否存在,如果存在，则读取其余额
	try {
		if(rs.next()){
		    result=rs.getString(1);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		sqlHelper.close(rs,sqlHelper.getPs(),sqlHelper.getCt());
	}
	return result;		
}
//更新密码
public void updatePassword(String cardID,String newPassword){
	String sql="update hnxscard set password=? where cardId=?";
	String parameters[]={newPassword,cardID};
	try {
		sqlHelper.executeUpdate(sql, parameters);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//检查余额是否足够操作
public boolean ifEnough(String cardID,int number){
	if(this.checkNumber(cardID)>=number)
		return true;
	else
		return false;
}
}
