package project1.ultil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project1.bean.User;
import project1.bean.Post;

public class DBUltil {
	public static User findUser(Connection conn, String name, String password, Boolean isActive) throws SQLException {

		String sql = "Select user_name, password, is_active from public.user "
				+ " where user_name = ? and password= ? and is_active= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setString(2, password);
		pstm.setBoolean(3, isActive);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setActivate(isActive);
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

	// public static User findUserbyId(Connection conn, String name) throws
	// SQLException {
	//
	// String sql = "Select user_id from public.user" + " where user_name = ?";
	//
	// PreparedStatement pstm = conn.prepareStatement(sql);
	// pstm.setString(1, name);
	// ResultSet rs = pstm.executeQuery();
	//
	// if (rs.next()) {
	// User user = new User();
	// user.setName(rs.getString("name"));
	// user.setUserId(rs.getInt("user_id"));
	// return user;
	// }
	// return null;
	// }

	public static User findUserbyName(Connection conn, String name) throws SQLException {

		String sql = "Select user_id, user_name, password, email, create_at, update_at from public.user"
				+ " where user_name = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setCreateAt(rs.getDate("create_at"));
			user.setUpdateAt(rs.getDate("update_at"));

			return user;

		}
		return null;
	}

	public static Post showAllPost(Connection conn, int userId) throws SQLException {

		String sql = "Select post_id, post_name, content, user_id from public.post" + " where user_id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			Post post = new Post();
			post.setPostId(rs.getInt("post_id"));
			post.setName(rs.getString("post_name"));
			post.setContent(rs.getString("content"));
			post.setUserId(rs.getInt("user_id"));

			return post;
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

	public static void activateAccount(Connection conn, User user) throws SQLException {
		String sql = "Update public.user set is_active =true where user_name=? and password=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getName());
		pstm.setString(2, user.getPassword());
		System.out.println(pstm);
		pstm.executeUpdate();

	}

	public static void changeProfile(Connection conn, User user) throws SQLException {
		String sql = "Update public.user set password =?, email =? where user_name=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getPassword());
		pstm.setString(2, user.getEmail());
		pstm.setString(3, user.getName());
		System.out.println(pstm);
		pstm.executeUpdate();

	}

	public static void creatPost(Connection conn, Post post, int userId) throws SQLException {
		String sql = "Insert into public.post(post_name, content, user_id) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, post.getName());
		pstm.setString(2, post.getContent());
		pstm.setInt(3, userId);
		System.out.println(pstm);
		pstm.executeUpdate();

	}
}
