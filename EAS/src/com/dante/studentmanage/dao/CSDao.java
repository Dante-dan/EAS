package com.dante.studentmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dante.studentmanage.util.DBUtil;

/**
*@author: Dante
*@version: 2017年3月19日下午6:42:36
*
**/
public class CSDao {
	private Connection connection;
	private PreparedStatement ps;
	public CSDao(){
		connection = DBUtil.makeConnection();
	}
	/**
	 * 添加课程学生关联信息
	 */
	public boolean addCS(int sid,int cid){
		String sql = "INSERT INTO cs(c_id,s_id) VALUES (?,?);";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, sid);
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
	/***
	 * 删除课程表关联信息
	 */
	public boolean deleteCS(int cid , int sid){
		/*
		 * 删除课程信息
		 */
		String sql = "DELETE FROM cs WHERE c_id=? AND s_id=? ;";
		try{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, sid);
			if(ps.executeUpdate()>0){
			return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return false;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	
}
