package com.dante.studentmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dante.studentmanage.entity.Teacher;
import com.dante.studentmanage.entity.User;
import com.dante.studentmanage.util.DBUtil;

/**
*@author: Dante
*@version: 2017年3月16日下午5:21:26
*
**/
public class TeacherDao {
	private Connection connection;
	private PreparedStatement ps;

	public TeacherDao() {
		connection = DBUtil.makeConnection();
	}

	/*
	 * 添加教师信息
	 */
	public boolean addTeacher(String nickname){
		String sql = "insert into teacher(nickname)"
				+ "values(?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, nickname);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	
	public List<Teacher> getAll() {
		/**
		 * 查询所有教师信息
		 */
		String sql = "select * from teacher;";
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Teacher> slList = new ArrayList<Teacher>();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTid(rs.getInt(1));
				teacher.setNickname(rs.getString(2));
				teacher.setRealname(rs.getString(3));
				teacher.setMajor(rs.getString(4));
				teacher.setUid(rs.getInt(5));
				slList.add(teacher);
			}
			return slList;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	 

	/*
	 * 修改教师信息
	 */
	public boolean changeTeacher(Teacher teacher) {
		connection = DBUtil.makeConnection();
		String sql = "update teacher set username=?,realname=?,major=?"
				+ "where t_id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, teacher.getNickname());
			ps.setString(2, teacher.getRealname());
			ps.setString(3, teacher.getMajor());
			ps.setInt(4, teacher.getTid());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	public Teacher getById(int id){
		String sql = "select * from teacher where t_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Teacher teacher = new Teacher();
			while (rs.next()) {
				teacher.setTid(rs.getInt(1));
				teacher.setNickname(rs.getString(2));
				teacher.setRealname(rs.getString(3));
				teacher.setMajor(rs.getString(4));
			}
			return teacher;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}
	public boolean deleteTeacher(int id) {
		String sql = "delete from teacher where u_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
}
