package com.dante.studentmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.omg.CORBA.INTERNAL;

import com.dante.studentmanage.entity.Course;
import com.dante.studentmanage.entity.Teacher;
import com.dante.studentmanage.util.DBUtil;

/**
*@author: Dante
*@version: 2017年3月17日下午3:54:48
*
**/
public class CourseDao {
	private Connection connection;
	private PreparedStatement ps;
	private PreparedStatement ps2;
	public CourseDao(){
		connection = DBUtil.makeConnection();
	}

	/*
	 * 添加课程信息
	 */
	public boolean addCourse(Course course){
		String sql = "insert into course(name,volume,time)"
				+ "values(?,?,?)";
		String sql2 = "SELECT c_id FROM course WHERE name=? AND volume=? AND time=? ;";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setInt(2, course.getVolume());
			ps.setString(3, course.getTime());
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
	public Course getByID(int id) {
		/**
		 * 根据id查询课程信息
		 */
		String sql = "SELECT * FROM course WHERE c_id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Course course = new Course();
			while (rs.next()) {

				course.setCid(rs.getInt(1));
				course.setName(rs.getString(2));
				course.setVolume(rs.getInt(3));
				course.setTime(rs.getString(4));
			}
			return course;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	/***
	 * public List<Course> getByTiD(int id) {
		/**
		 * 根据教师id查询课程信息
		 */
		/*String sql = "select * from course where course.c_id in("
				+ "select c_id from ct where ct.t_id = ?);";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Course course = new Course();
			List<Course> slList = new ArrayList<Course>();
			while (rs.next()) {

				course.setCid(rs.getInt(1));
				course.setName(rs.getString(2));
				course.setVolume(rs.getInt(3));
				course.setTime(rs.getString(4));
				slList.add(course);
			}
			return slList;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	 * @param id
	 * @return
	 */
	
	public boolean deleteCourse(int id){
		/*
		 * 删除课程信息
		 */
		String sql = "delete from course where id=?";
		try{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate()>0){
			return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
/*	public Map<String, List<Object>> getAll_teacher(){
		/**
		 * 查询所有课程信息包含教师信息
		 */
/*		String sql = "SELECT course.c_id,course.name,course.volume,course.time,teacher.realname FROM course LEFT JOIN"
				+ "ct on course.c_id=ct.c_id LEFT JOIN teacher ON teacher.t_id=ct.t_id;";
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Object>  slList= new ArrayList<>();
			List<Object> tList=new ArrayList<>();
			Map<String, List<Object>>  map=new HashMap<String,List<Object>>();
			while (rs.next()) {
				Course course = new Course();
				course.setCid(rs.getInt(1));
				course.setName(rs.getString(2));
				course.setVolume(rs.getInt(3));
				course.setTime(rs.getString(4));
				slList.add(course);
				
				Teacher teacher =new Teacher();
				teacher.setRealname(rs.getString(5));
				tList.add(teacher);	 
				}
			}
			map.put("slList", slList);
			map.put("tList", tList);
			
			return map;
		} catch (SQLException e) {
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}
	*/
	public List<Map<Integer,String>> getAll(){
		/**
		 * 查询所有课程信息
		 */
		String sql = "SELECT course.c_id,course.name,course.volume,course.time,teacher.realname,teacher.t_id FROM course LEFT JOIN "
				+ " ct on course.c_id=ct.c_id LEFT JOIN teacher ON teacher.t_id=ct.t_id;";
		
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Map<Integer,String>> slList = new ArrayList<Map<Integer,String>>();
			while (rs.next()) {
				int i=1;
				Course course = new Course();
				Map<Integer, String> map = new HashMap();
				map.put(i, (String.valueOf(rs.getInt(1))));
				i++;
				map.put(i,rs.getString(2));
				i++;
				map.put(i,(String.valueOf(rs.getInt(3))));
				i++;
				map.put(i,rs.getString(4));
				i++;
				map.put(i,rs.getString(5));
				i++;
				map.put(i, (String.valueOf(rs.getInt(6))));
				slList.add(map);
			}
			return slList;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return null;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}

	}	
	public List<Map<Integer,String>> getAll(int id){
		/**
		 * 根据教师id查询所有课程信息
		 */
		String sql = "SELECT course.c_id,course.name,course.volume,course.time,teacher.realname,teacher.t_id FROM course LEFT JOIN "
				+ "ct on course.c_id=ct.c_id LEFT JOIN teacher ON teacher.t_id=ct.t_id WHERE ct.t_id="+id;
		
		try {
			ps = connection.prepareStatement(sql);
//			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Map<Integer,String>> slList = new ArrayList<Map<Integer,String>>();
			
			while (rs.next()) {
				int i=1;
				Course course = new Course();
				Map<Integer, String> map = new HashMap();
				map.put(i, (String.valueOf(rs.getInt(1))));
				i++;
				map.put(i,rs.getString(2));
				i++;
				map.put(i,(String.valueOf(rs.getInt(3))));
				i++;
				map.put(i,rs.getString(4));
				i++;
				map.put(i,rs.getString(5));
				i++;
				map.put(i, (String.valueOf(rs.getInt(6))));
				slList.add(map);
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
	public boolean changeCourse(Course course){
		String sql="UPDATE course SET name= ? , volume = ? , time = ? WHERE c_id = ?";
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setInt(2,course.getVolume());
			ps.setString(3, course.getTime());
			ps.setInt(4, course.getCid());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	public List<Course> getBySid(int id){
		String sql = "SELECT course.c_id ,course.name,course.volume,course.time "
				+ " FROM course LEFT JOIN cs ON course.c_id = cs.c_id LEFT JOIN student ON student.s_id = cs.s_id where cs.s_id = ? ;";
		List<Course> list = new ArrayList<Course>();
		
		try {
			ps=connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCid(rs.getInt(1));
				course.setName(rs.getString(2));
				course.setVolume(rs.getInt(3));
				course.setTime(rs.getString(4));
				list.add(course);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return null;
		}finally {
			DBUtil.closeConnection(ps, connection);
		}
		
	}

	/*
	 * 添加课程信息
	 */
	public int getCid(Course course){
		String sql = "SELECT c_id FROM course WHERE name=? AND volume=? AND time=? ;";
		int cid=0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setInt(2, course.getVolume());
			ps.setString(3, course.getTime());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cid = rs.getInt(1);
			}
			return cid;
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return 0;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
}
