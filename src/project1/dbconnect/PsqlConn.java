package project1.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PsqlConn {

	public static Connection getPSQLConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String dbName = "project1";
		String userName = "postgres";
		String password = "zxcvbn";
		return getPSQLConnection(hostName, dbName, userName, password);

	}

	public static Connection getPSQLConnection(String hostName, String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException {

		String connectionURL = "jdbc:postgresql://localhost:5432/project1";
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;

	}
}