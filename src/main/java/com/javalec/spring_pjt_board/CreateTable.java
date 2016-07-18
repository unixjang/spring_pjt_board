package com.javalec.spring_pjt_board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	// private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/spring_pjt_board";
	private static final String USER = "root"; //db 접속 id
	private static final String PW = "wlvlwlrl87!"; //db 접속 password
	private static Statement stmt = null;
	private static Connection conn = null;
	
	public static void main(String args[]) throws Exception{
		createTable();
	}
	
	public static void createTable() throws Exception{		
		try{
			conn = DriverManager.getConnection(URL, USER, PW);
			stmt = conn.createStatement();
			String sql = 
				"CREATE TABLE mvc_board (" +
				" bId INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
				" bName VARCHAR(20), " + 
				" bTitle VARCHAR(100), " + 
				" bContent VARCHAR(300), " + 
				" bDate DATETIME, " + 
				" bHit INT(4) DEFAULT 0, " + 
				" bGroup INT(4), " + 
				" bStep INT(4), " + 
				" bIndent INT(4))";
			stmt.executeUpdate(sql);
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			// finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
				}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
	System.out.println("Create Table DONE!");
	}
}
