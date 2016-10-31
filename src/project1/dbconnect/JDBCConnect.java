package project1.dbconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import project1.dbconnect.DBConnect;

public class JDBCConnect {
	public static ResultSet QueryData(Connection connection) throws SQLException, ClassNotFoundException {
		connection = DBConnect.getConnection();
		Statement statement = connection.createStatement();
		String sql = "Select user_name, user_password from User";
		ResultSet rs = statement.executeQuery(sql);
		connection.close();
		return rs;
	}
}
