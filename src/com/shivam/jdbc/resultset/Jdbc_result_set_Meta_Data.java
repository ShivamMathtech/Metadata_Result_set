package com.shivam.jdbc.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Jdbc_result_set_Meta_Data {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Shivam");
			st = con.createStatement();
			rs= st.executeQuery("select * from EMP1");
			rsmd = rs.getMetaData();
			System.out.println("Meta data about the Empoloyee Table");
		    int count = rsmd.getColumnCount();
		    for (int i =1; i<=count;i++) {
		    	System.out.println("Column Name       :"+rsmd.getColumnName(i));
		    	System.out.println("Column Data Type  :"+rsmd.getColumnType(i));
		    	System.out.println("Column Size       :"+rsmd.getColumnDisplaySize(i));
		    	System.out.println("Table Name        :"+rsmd.getTableName(i));
		    	System.out.println("----------------------------------------");
		    	
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
