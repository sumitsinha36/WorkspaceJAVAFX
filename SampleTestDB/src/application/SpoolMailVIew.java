package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.SpoolMailViewController;
import libconnection.DBConnection;

public class SpoolMailVIew {

	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	private static String sql;
	
	
	public static void main(String[] args) {
		DBConnection.setIpAddress("10.201.148.67");
		DBConnection.setPortAddress("7706");
		DBConnection.setDatabaseName("out_messages");
		DBConnection.setUserid("root");
		DBConnection.setPassword("em7admin");
		DBConnection.setUrl();

		
		
		sql="select id,roa_id,priority,state,eid,submit_stamp,send_stamp,status from out_messages.spool_mail where eid = 0";
		try {
			conn=DBConnection.connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				System.out.println();
			    System.out.print("\t"+rs.getString("id"));
			    System.out.print("\t"+rs.getString("state"));
			    System.out.print("\t"+rs.getString("submit_stamp"));
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	      
	}
	
	
	

}
