package entity.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	private static Connection con = null;
	private static DButil dbUtil = null;

	public Connection getconnection() {
		try {
			if (con == null || con.isClosed())
				;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded and registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xml-parsing?user=root&password=kiran");
			System.out.println("connection is established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static DButil getInstance() {
		if (dbUtil == null) {
			dbUtil = new DButil();
		}

		return dbUtil;
	}

	public static void closeresource(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
