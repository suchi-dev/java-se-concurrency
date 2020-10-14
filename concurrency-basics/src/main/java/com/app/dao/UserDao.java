package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.beans.User;

public class UserDao {

	public int saveAllUsers(User user) {
		int row = 0;
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into users values(? , ?, ?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmailAddress());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return row;

	}

}
