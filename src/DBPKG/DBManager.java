package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
		return con;
	}

	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null ) conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}