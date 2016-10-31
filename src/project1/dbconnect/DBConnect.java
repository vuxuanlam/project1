package project1.dbconnect;

import java.sql.SQLException;
import java.sql.Connection;
import project1.dbconnect.PsqlConn;

public class DBConnect {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return PsqlConn.getPSQLConnection();
	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
