package com.markey.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.markey.util.sqlHelper;

public class cardService {
//��ѯ�˺�
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
//��ѯ���
public int checkNumber(String cardID){
		
        int result=0;		
		//ʹ��sqlHelper����ɲ�ѯ����
		String sql="select number from hnxscard where cardId=?";
		String parameters[]={cardID};
		ResultSet rs=sqlHelper.executeQuery(sql, parameters);
		//����rs���жϸ��û��Ƿ����,������ڣ����ȡ�����
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
//ȡ��
public void getNumber(String cardID,int number){
	//�������ݿ����
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
//���
public void putNumber(String bankCard,String cardID,int number){
	//�������ݿ����
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
//��ѯ����
public String checkPassword(String cardID){
	String result=null;
	//ʹ��sqlHelper����ɲ�ѯԭ����
	String sql="select password from hnxscard where cardId=?";
	String parameters[]={cardID};
	ResultSet rs=sqlHelper.executeQuery(sql, parameters);
	//����rs���жϸ��û��Ƿ����,������ڣ����ȡ�����
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
//��������
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
//�������Ƿ��㹻����
public boolean ifEnough(String cardID,int number){
	if(this.checkNumber(cardID)>=number)
		return true;
	else
		return false;
}
}
