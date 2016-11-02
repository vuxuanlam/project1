package project1.ultil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project1.bean.User;

public class DBUltil {
	public static User findUser(Connection conn, String name, String password) throws SQLException {

		String sql = "Select user_name, password from public.user " + " where user_name = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			return user;
		}
		return null;
	}

	public static User findUser(Connection conn, String name) throws SQLException {

		String sql = "Select user_name, password from public.user " + " where user_name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			return user;
		}
		return null;

	}

	public static void insertUser(Connection conn, User user) throws SQLException {
		String sql = "Insert into public.user(user_name, password, email) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getName());
		pstm.setString(2, user.getPassword());
		pstm.setString(3, user.getEmail());
		System.out.println(pstm);
		pstm.executeUpdate();
	}
}
