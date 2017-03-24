package com.dante.studentmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.dante.studentmanage.entity.User;
import com.dante.studentmanage.util.DBUtil;


/**
 * @author: Dante
 * @version: 2017年3月3日下午3:19:24
 *
 **/

public class UserDao {

	private Connection connection;
	private Connection connection2;
	private PreparedStatement ps;
	private PreparedStatement ps2 ;
	public UserDao() {
		connection = DBUtil.makeConnection();
	}
	/**
	 * 验证用户权限
	 * 
	 * @param user
	 * @return
	 */
	public int validate(User user) {
		String sql = "select * from user where username=? and password=?";
		connection = DBUtil.makeConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {

				user.setId(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setAuthor(resultSet.getString(4));
				if(user.getAuthor().equals("0")){
					return 0;
				}
				if(user.getAuthor().equals("1")){
					return 1;
				}
				if(user.getAuthor().equals("2")){
					return 2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	/*
	 * 添加用户信息
	 */
	public boolean addUser(User user) {
		String sql = "insert into user(username,password,author)"
				+ "values(?,?,?)";
		connection = DBUtil.makeConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAuthor());
			if(user.getAuthor().equals("2")){
				StudentDao studentDao = new StudentDao();
				studentDao.addStudent(user.getUsername());
			}
			if(user.getAuthor().equals("1")){
				TeacherDao teacherDao = new TeacherDao();
				teacherDao.addTeacher(user.getUsername());
			}
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	public List<User> getAll() {
		/**
		 * 查询所有用户信息
		 */
		String sql = "select * from user";
		connection = DBUtil.makeConnection();
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<User> slList = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setAuthor(rs.getString(4));
				slList.add(user);
			}
			return slList;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	public User getByID(int id) {
		/**
		 * 根据id查询用户信息
		 */
		String sql = "select * from user where id=?";
		connection = DBUtil.makeConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			while (rs.next()) {

				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAuthor(rs.getString(4));
			}
			return user;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	/*
	 * 修改用户信息
	 */
	public boolean changeUser(User user) {
		connection = DBUtil.makeConnection();
		String sql = "update user set username=?,password=?,author=?"
				+ "where id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAuthor());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}

	public boolean deleteUser(int id) {
		String sql = "delete from user where uid = ?";
		connection = DBUtil.makeConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return false;
		}finally {
			DBUtil.closeConnection(ps, connection);
		}
		return false;
	}
	public int getTidByUsername(String username) {
		/**
		 * 根据老师用户名获得教师id
		 */
		String sql = "select t_id from teacher where username= ? ;";
		connection = DBUtil.makeConnection();
		int tid=0;
		try{
			ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tid=rs.getInt(1);
			}
			return tid;
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return 0;
		}finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	public int getSidByUsername(String username) {
		/*
		 * 根据学生用户名获得学生id
		 */
		String sql = "select s_id from student where nickname= ? ;";
		connection = DBUtil.makeConnection();
		int sid=0;
		try{
			ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sid=rs.getInt(1);
			}
			return sid;
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return 0;
		}finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	public boolean check(String username){
		/**
		 * 根据用户名检验重复
		 */
		connection = DBUtil.makeConnection();
//		connection2 = DBUtil.makeConnection();
		String sql = "select * from teacher where username =?";
		String sql2 ="select * from student where nickname =?";
		try {
			ps = connection.prepareStatement(sql);
			ps2 = connection.prepareStatement(sql2);
			ps.setString(1, username);
			ps2.setString(1, username);
			ResultSet rs = ps.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			Boolean aBoolean=rs.next();
			Boolean bBoolean=rs2.next();
			if(!(rs.next()&&rs2.next())){
				return true;
			}else{                                   
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			DBUtil.roll(ps2, connection, e);
			return false;
		}
		finally {
			DBUtil.closeConnection(ps, connection);
//			DBUtil.closeConnection(ps2, connection);
		}
	}
}
