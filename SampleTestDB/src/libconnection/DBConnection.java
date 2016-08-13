package libconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn;
	private static String url; // =
								// "jdbc:mysql://10.201.148.67:7706/testjavafx";
	private static String ipAddress;
	private static String portAddress;
	private static String databaseName;
	private static String userid; // = "root";
	private static String password; // = "em7admin";

	public static Connection connect() throws SQLException {
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (ClassNotFoundException cnfException) {
			System.out.println("Error : " + cnfException.getMessage());
		} catch (InstantiationException insException) {
			System.out.println("Error : " + insException.getMessage());
		} catch (IllegalAccessException ilgException) {
			System.out.println("Error : " + ilgException.getMessage());
		}
		conn = DriverManager.getConnection(url, userid, password);
		return conn;
	}

	public static Connection getConn() throws SQLException,
			ClassNotFoundException, Exception {
		if (conn != null && !conn.isClosed())
			return conn;
		connect();
		return conn;
	}

	public static void setConn(Connection conn) {
		DBConnection.conn = conn;
	}

	public static String getIpAddress() {
		return ipAddress;
	}

	public static void setIpAddress(String ipAddress) {
		DBConnection.ipAddress = ipAddress;
	}

	public static String getPortAddress() {
		return portAddress;
	}

	public static void setPortAddress(String portAddress) {
		DBConnection.portAddress = portAddress;
	}

	public static String getDatabaseName() {
		return databaseName;
	}

	public static void setDatabaseName(String databaseName) {
		DBConnection.databaseName = databaseName;
	}

	public static String getUrl() {
		if (url != null )
			return url;
		setUrl();
		return DBConnection.url;
	}

	public static void setUrl() {
		DBConnection.url = "jdbc:mysql://" + getIpAddress() + ":" + getPortAddress() + "/" + getDatabaseName();
	}

	public static String getUserid() {
		return userid;
	}

	public static void setUserid(String userid) {
		DBConnection.userid = userid;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DBConnection.password = password;
	}

}
