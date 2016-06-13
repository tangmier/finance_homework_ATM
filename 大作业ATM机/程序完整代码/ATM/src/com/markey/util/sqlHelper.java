package com.markey.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class sqlHelper {

	//������Ҫ�ı���
	private static Connection ct=null;
	//�ڴ��������£�����ʹ�õ���PrepardStatement�����statement
	//�������Է�ֹsqlע��
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static CallableStatement cs=null;
	
	//�������ݿ����
	private static String url="";
	private static String username="";
	private static String driver="";
	private static String password="";
	//��ȡ�����ļ�
	private static Properties pp=null;
	private static InputStream fis=null;
	//�������� ��ֻ��Ҫһ��
	static{
		
		try {
			pp=new Properties();
			//������ʹ��java web��ʱ�򣬶�ȡ�ļ�Ҫ���������,Ĭ��Ŀ¼��srcĿ¼
			fis=sqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);
			url=pp.getProperty("url");
			username=pp.getProperty("username");
			driver=pp.getProperty("driver");
			password=pp.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fis=null;
		}
	}
	//�õ�����
	public static Connection getConnection(){
		try {
			ct=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}
	//��ҳ����
	public static ResultSet executeQuery2(){
		return null;
		
	}
	//���ô洢���� �з���result
	//sql call���̣�������������
	public static CallableStatement callPro2
	(String sql,String [] inparameters, Integer [] outparmeters){
		
		try {
			ct=getConnection();
			cs=ct.prepareCall(sql);
			if(inparameters!=null){
				for(int i=0;i<inparameters.length;i++){
					cs.setObject(i+1, inparameters[i]);
				}
			}
			//��out������ֵ
			if(outparmeters!=null){
				for(int i=0;i<outparmeters.length;i++){
					cs.registerOutParameter(inparameters.length+1, outparmeters[i]);
				}
			}
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			//����Ҫ�ر�
		}
		return cs;
	}
	//���ô洢����
	//sql {call ���̣�������������}
	public static void callPro1(String sql,String []parameters){
		
		try {
			ct=getConnection();
			cs=ct.prepareCall(sql);
			
			//�����Ÿ�ֵ
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					cs.setObject(i+1, parameters[i]);
					
				}
			}
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,cs,ct);
		}
		
	}
    //ͳһ��select
	//ResultSet->ArrayList
	public static ResultSet executeQuery(String sql,String []parameters){
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			
			//�����Ÿ�ֵ
			if(parameters!=null&&!parameters.equals("")){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
					
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			//close(rs,cs,ct);
		}

		return rs;
		
	}
	//����ж��update/ delete/ insert ����Ҫ��������
	public static void executeUpdate2(String sql[],String [] []parameters){
		
		try {
			ct=getConnection();
			ct.setAutoCommit(false);
			for(int i=0;i<sql.length;i++){
				if(parameters[i]!=null){
					ps=ct.prepareStatement(sql[i]);
					for(int j=0;j<parameters[i].length;j++){
						ps.setString(j+1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}
			ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				ct.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,ps,ct);
		}
		
	}
	//sql ��ʽ��update ���� set �ֶ���=�� where �ֶ�=��
	//parametersӦ����{��abc����23}
	public static void executeUpdate(String sql,String [] parameters){
		try {
			ct=getConnection();
			ps=ct.prepareCall(sql);
			
			//�����Ÿ�ֵ
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
					
				}
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,cs,ct);
		}

	}
	//�ر���Դ�ĺ���
	public static void close(ResultSet rs,Statement ps,Connection ct){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ct!=null){
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}
}
