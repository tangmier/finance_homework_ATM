package com.markey.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class sqlHelper {

	//定义需要的变量
	private static Connection ct=null;
	//在大多数情况下，我们使用的是PrepardStatement来替代statement
	//这样可以防止sql注入
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static CallableStatement cs=null;
	
	//连接数据库参数
	private static String url="";
	private static String username="";
	private static String driver="";
	private static String password="";
	//读取配置文件
	private static Properties pp=null;
	private static InputStream fis=null;
	//加载驱动 ，只需要一次
	static{
		
		try {
			pp=new Properties();
			//当我们使用java web的时候，读取文件要用类加载器,默认目录是src目录
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
	//得到连接
	public static Connection getConnection(){
		try {
			ct=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}
	//分页问题
	public static ResultSet executeQuery2(){
		return null;
		
	}
	//调用存储过程 有返回result
	//sql call过程（？，？，？）
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
			//给out参数赋值
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
			//不需要关闭
		}
		return cs;
	}
	//调用存储过程
	//sql {call 过程（？，？，？）}
	public static void callPro1(String sql,String []parameters){
		
		try {
			ct=getConnection();
			cs=ct.prepareCall(sql);
			
			//给？号赋值
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
    //统一的select
	//ResultSet->ArrayList
	public static ResultSet executeQuery(String sql,String []parameters){
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			
			//给？号赋值
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
	//如果有多个update/ delete/ insert 【需要考虑事务】
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
	//sql 格式：update 表名 set 字段名=？ where 字段=？
	//parameters应该是{“abc”，23}
	public static void executeUpdate(String sql,String [] parameters){
		try {
			ct=getConnection();
			ps=ct.prepareCall(sql);
			
			//给？号赋值
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
	//关闭资源的函数
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
