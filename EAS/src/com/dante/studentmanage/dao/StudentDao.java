package com.dante.studentmanage.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.dante.studentmanage.entity.Student;
import com.dante.studentmanage.util.DBUtil;

/**
 * @author: Dante
 * @version: 2017年3月6日下午8:04:01
 *
 **/
public class StudentDao {
	private Connection connection;
	private PreparedStatement ps;

	public StudentDao() {
		connection = DBUtil.makeConnection();
	}

	/*
	 * 添加学生信息
	 */
	public boolean addStudent(String nickname){
		String sql = "insert into student(nickname)"
				+ "values(?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, nickname);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		}
			finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	public boolean addStudent(Student student) {
		String sql = "insert into student(nickname,realname,gender,birthday,major,interest,remark)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, student.getNickname());
			ps.setString(2, student.getRealname());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getBirthday());
			ps.setString(5, student.getMajor());
//			ps.setString(6, student.getCourses());
			ps.setString(7, student.getInterests());
			ps.setString(8, student.getRemark());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	public List<Student> getAll() {
		/**
		 * 查询所有学生信息
		 */
		String sql = "select * from student";
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Student> slList = new ArrayList<Student>();
			while (rs.next()) {
				Student student = new Student();
				student.setSid(rs.getInt(1));
				student.setNickname(rs.getString(2));
				student.setRealname(rs.getString(3));
				student.setGender(rs.getString(4));
				student.setBirthday(rs.getString(5));
				student.setMajor(rs.getString(6));
				student.setInterests(rs.getString(7));
				student.setRemark(rs.getString(8));
				slList.add(student);
			}
			return slList;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	public Student getByID(int id) {
		/**
		 * 根据id查询学生信息
		 */
		String sql = "select * from student where s_id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Student student = new Student();
			while (rs.next()) {

				student.setSid(rs.getInt(1));
				student.setNickname(rs.getString(2));
				student.setRealname(rs.getString(3));
				student.setGender(rs.getString(4));
				student.setBirthday(rs.getString(5));
				student.setMajor(rs.getString(6));
//				student.setCourses(rs.getString(7));
				student.setInterests(rs.getString(7));
				student.setRemark(rs.getString(8));
			}
			return student;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	/*
	 * 修改学生信息
	 */
	public boolean changeStudnt(Student student) {
		connection = DBUtil.makeConnection();
		String sql = "update student set nickname=?,realname=?,gender=?,birthday=?,major=?,"
				+ "interest=?,remark=? where s_id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, student.getNickname());
			ps.setString(2, student.getRealname());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getBirthday());
			ps.setString(5, student.getMajor());
			ps.setString(6, student.getInterests());
			ps.setString(7, student.getRemark());
			ps.setInt(8, student.getSid());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	public boolean deleteStudent(int id) {
		String sql = "delete from student where u_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		}
		return false;
	}
}
