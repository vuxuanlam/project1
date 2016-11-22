package project1.ultil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import project1.bean.*;

public class DBUltil {

	public static User findUser(Connection conn, String name, String password, Boolean isActive) throws SQLException {

		String sql = "Select * from public.user " + " where user_name = ? and password= ? and is_active= ? ";
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
			user.setRole(rs.getBoolean("is_role"));
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

	public static Post findPost(Connection conn, int user_Id) throws SQLException {

		String sql = "Select * from public.post " + " where user_id = ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, user_Id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			Post post = new Post();
			post.setPostId(rs.getInt("post_id"));
			return post;
		}
		return null;
	}

	public static Post findPostbyId(Connection conn, int post_Id) throws SQLException {
		String sql = "Select * from public.post " + " where post_id = ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, post_Id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			Post post = new Post();
			post.setPostId(rs.getInt("post_id"));
			post.setName(rs.getString("post_name"));
			post.setContent(rs.getString("content"));
			post.setUserId(rs.getInt("user_id"));
			post.setCreateAt(rs.getTimestamp("create_at"));
			post.setUpdateAt(rs.getTimestamp("update_at"));
			return post;
		}
		return null;
	}

	public static Comment findComment(Connection conn, int post_Id) throws SQLException {
		String sql = "Select * from public.comment " + " where post_id = ?  ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, post_Id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			Comment comment = new Comment();
			comment.setPost_Id(rs.getInt("comment_id"));
			comment.setPost_Id(rs.getInt("post_id"));
			comment.setUser_Id(rs.getInt("user_id"));
			comment.setContent(rs.getString("content"));
			comment.setCreateAt(rs.getTimestamp("create_at"));
			comment.setUpdateAt(rs.getTimestamp("update_at"));
			return comment;

		}
		return null;

	}

	public static List<Tag> findTag(Connection conn, String tagName) throws SQLException {
		String sql = "Select * from public.tag where tag_name like ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%" + tagName + "%");
		ResultSet rs = pstm.executeQuery();
		List<Tag> listTag = new ArrayList<Tag>();
		while (rs.next()) {
			Tag tag = new Tag();
			tag.setTag_id(rs.getInt("tag_id"));
			listTag.add(tag);
		}
		return listTag;
	}

	public static PostTag findPostTag(Connection conn, int tagId) throws SQLException {
		String sql = "Select * from public.post_tag where tag_id = ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, tagId);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			PostTag postTag = new PostTag();
			postTag.setPost_Id(rs.getInt("post_id"));
			return postTag;
		}
		return null;

	}

	// public static List<Tag> search(Connection conn, String tagName) throws
	// SQLException {
	// String sql = "Select * from public.tag where tag_name like '?%'";
	// PreparedStatement pstm = conn.prepareStatement(sql);
	// pstm.setString(1, tagName);
	// ResultSet rs = pstm.executeQuery();
	// if (rs.next()) {
	// Tag tag = new Tag();
	// tag.setTag_id(rs.getInt("tag_id"));
	// // tag.setTag_name(rs.getString("tag_name"));
	// return tag;
	// }
	// return null;
	// }
	// public static Post findPostByName(Connection conn, String postName)
	// throws SQLException {
	// String sql = "Select * from public.post " + " where post_name = ? ";
	//
	// PreparedStatement pstm = conn.prepareStatement(sql);
	// pstm.setString(1, postName);
	// ResultSet rs = pstm.executeQuery();
	//
	// if (rs.next()) {
	// Post post = new Post();
	// post.setPostId(rs.getInt("post_id"));
	// post.setName(postName);
	// return post;
	// }
	// return null;
	//
	// }

	public static User findUserbyId(Connection conn, int userId) throws SQLException {

		String sql = "Select * from public.user" + " where user_id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			User user = new User();
			user.setName(rs.getString("user_name"));
			user.setUserId(rs.getInt("user_id"));
			return user;
		}
		return null;
	}

	public static User findUserbyName(Connection conn, String name) throws SQLException {

		String sql = "Select * from public.user" + " where user_name = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setCreateAt(rs.getTimestamp("create_at"));
			user.setUpdateAt(rs.getTimestamp("update_at"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		return null;
	}

	public static List<Post> viewMyPost(Connection conn, int userId) throws SQLException {

		String sql = "Select * from public.post" + " where user_id = ? Order By post_id desc";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, userId);
		ResultSet rs = pstm.executeQuery();
		List<Post> listPost = new ArrayList<Post>();
		while (rs.next()) {
			Post post = new Post();
			post.setPostId(rs.getInt("post_id"));
			post.setName(rs.getString("post_name"));
			post.setContent(rs.getString("content"));
			post.setUserId(rs.getInt("user_id"));
			post.setCreateAt(rs.getTimestamp("create_at"));
			post.setUpdateAt(rs.getTimestamp("update_at"));
			listPost.add(post);
		}
		return listPost;
	}

	public static List<User> viewAllUser(Connection conn) throws SQLException {

		String sql = "Select * from public.user Order By user_id desc ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<User> listUser = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("user_id"));
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setCreateAt(rs.getTimestamp("create_at"));
			user.setUpdateAt(rs.getTimestamp("update_at"));
			listUser.add(user);
		}
		return listUser;
	}

	public static List<UserCommentPost> viewAllPost(Connection conn) throws SQLException {

		String sql = "Select * from public.post Order By post_id desc";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<UserCommentPost> listUserCommentPost = new ArrayList<UserCommentPost>();
		while (rs.next()) {
			UserCommentPost userCommentPost = new UserCommentPost();
			List<UserComment> listUserComment = new ArrayList<UserComment>();
			Post post = new Post();
			post.setPostId(rs.getInt("post_id"));
			post.setName(rs.getString("post_name"));
			post.setContent(rs.getString("content"));
			post.setUserId(rs.getInt("user_id"));
			post.setCreateAt(rs.getTimestamp("create_at"));
			post.setUpdateAt(rs.getTimestamp("update_at"));
			int post_Id = post.getPostId();
			listUserComment = showAllComment(conn, post_Id);
			userCommentPost.setPost(post);

			userCommentPost.setListUserComment(listUserComment);
			listUserCommentPost.add(userCommentPost);
		}
		return listUserCommentPost;
	}

	public static UserCommentPost search(Connection conn, int postId) throws SQLException {
		UserCommentPost userCommentPost = new UserCommentPost();
		List<UserComment> listUserComment = new ArrayList<UserComment>();
		String sql = "Select * from public.post where post_id = ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, postId);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Post post = new Post();
			post.setPostId(postId);
			post.setName(rs.getString("post_name"));
			post.setContent(rs.getString("content"));
			post.setUserId(rs.getInt("user_id"));
			post.setCreateAt(rs.getTimestamp("create_at"));
			post.setUpdateAt(rs.getTimestamp("update_at"));
			;
			listUserComment = showAllComment(conn, postId);
			userCommentPost.setPost(post);
			userCommentPost.setListUserComment(listUserComment);
		}
		return userCommentPost;
	}

	public static List<UserComment> showAllComment(Connection conn, int post_Id) throws SQLException {

		String sql = "Select * from public.comment where post_id =? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, post_Id);
		ResultSet rs = pstm.executeQuery();
		List<UserComment> listUserComment = new ArrayList<UserComment>();
		while (rs.next()) {
			UserComment userComment = new UserComment();
			Comment comment = new Comment();
			User user = new User();
			comment.setComment_Id(rs.getInt("comment_id"));
			comment.setContent(rs.getString("content"));
			comment.setPost_Id(rs.getInt("post_id"));
			comment.setUser_Id(rs.getInt("user_id"));
			user = findUserbyId(conn, rs.getInt("user_id"));
			comment.setCreateAt(rs.getTimestamp("create_at"));
			comment.setUpdateAt(rs.getTimestamp("update_at"));
			userComment.setComment(comment);

			userComment.setUser(user);
			listUserComment.add(userComment);
		}
		return listUserComment;

	}

	public static void deletePost(Connection conn, int post_Id) throws SQLException {

		String sql = "Delete from public.post where post_Id= ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, post_Id);
		System.out.println(pstm);
		pstm.executeUpdate();
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

	public static void activateAccount(Connection conn, String name) throws SQLException {

		String sql = "Update public.user set is_active =true where user_name=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, name);
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

	public static void editPost(Connection conn, Post post) throws SQLException {
		String sql = "Update public.post set post_name =?, content =?, create_at =?, update_at=? where post_id=? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, post.getName());
		pstm.setString(2, post.getContent());
		pstm.setTimestamp(3, post.getCreateAt());
		pstm.setTimestamp(4, post.getUpdateAt());
		pstm.setInt(5, post.getPostId());
		System.out.println(pstm);
		pstm.executeUpdate();
	}

	public static void creatPost(Connection conn, Post post, int userId) throws SQLException {

		String sql = "Insert into public.post(post_name, content, user_id) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		pstm.setString(1, post.getName());
		pstm.setString(2, post.getContent());
		pstm.setInt(3, userId);
		System.out.println(pstm);
		pstm.executeUpdate();
		try (ResultSet rs = pstm.getGeneratedKeys()) {
			if (rs.next()) {
				post.setPostId(rs.getInt(1));
			} else {
				throw new SQLException("Creating post failed, no ID obtained.");
			}
		}
	}

	public static void creatComment(Connection conn, String content, int postId, int userId) throws SQLException {

		String sql = "Insert into public.comment(post_id, user_id, content) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, postId);
		pstm.setInt(2, userId);
		pstm.setString(3, content);
		System.out.println(pstm);
		pstm.executeUpdate();

	}

	public static void insertTag(Connection conn, Tag tag, String tagName) throws SQLException {

		String sql = "Insert into public.tag(tag_name) values (?)";
		PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		pstm.setString(1, tagName);
		System.out.println(pstm);
		pstm.executeUpdate();
		try (ResultSet rs = pstm.getGeneratedKeys()) {
			if (rs.next()) {
				tag.setTag_id(rs.getInt(1));
			} else {
				throw new SQLException("Creating post failed, no ID obtained.");
			}
		}
	}

	public static void insertPostTag(Connection conn, int post_Id, int tag_Id) throws SQLException {

		String sql = "Insert into public.post_tag(post_id, tag_id) values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, post_Id);
		pstm.setInt(2, tag_Id);
		System.out.println(pstm);
		pstm.executeUpdate();

	}

	public static String encryptMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

}