package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCManager{
	static Connection conn = null;
	public static String bdd = "annu";
	public static String user = "tom";
	public static String pass = "tom";
	
	public static Connection ouvrirConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+bdd+"?" + "user="+user+"&password="+pass);		
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		/*} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void fermerConnection() {
		try {
			// fermeture de la connexion
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}
	
	
}
