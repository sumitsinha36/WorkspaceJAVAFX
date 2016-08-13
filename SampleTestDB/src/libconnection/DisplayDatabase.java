package libconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class DisplayDatabase {

	//textingmethod
	public void addData() throws SQLException{
	
		DBConnection.setIpAddress("10.201.148.67");
		DBConnection.setPortAddress("7706");
		DBConnection.setDatabaseName("testjavafx");
		DBConnection.setUserid("root");
		DBConnection.setPassword("em7admin");
		DBConnection.setUrl();
		
		Connection conn=DBConnection.connect();
		
		String SQL = "insert into student (rollnumber,sname) values ('10001','Amit kumar sinha')";
		Statement stmt= conn.createStatement();
		stmt.executeUpdate(SQL);
		System.out.println("Inserted");
	}
	
	public static void main(String args[]) throws SQLException{
		DisplayDatabase dd= new DisplayDatabase();
		dd.addData();
	}
	
}
