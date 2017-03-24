package com.dante.studentmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dante.studentmanage.util.DBUtil;

/**
*@author: Dante
*@version: 2017年3月19日下午7:01:23
*
**/

public class CTDao {
	private Connection connection;
	private PreparedStatement ps;
	public CTDao(){
		connection = DBUtil.makeConnection();
	}
	/**
	 * 添加课程学生关联信息
	 */
	public boolean addCT(int cid,int tid){
		String sql = "INSERT INTO ct(c_id,t_id) VALUES (?,?);";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, tid);
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
	public boolean deleteCT(int cid , int tid){
		/*
		 * 删除课程信息
		 */
		String sql = "DELETE FROM ct WHERE c_id=? AND t_id=? ;";
		try{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, tid);
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
	/**
	 * 
	 * 根据cid查询授课老师id
	 */
	public int getTidByCid(int cid){
		String sql = "SELECT * FROM ct WHERE c_id=? ;";
		int tid=0;
		try {
			ps=connection.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				tid=rs.getInt(1);
			}
			return tid;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.roll(ps, connection, e);
			return tid;
		} finally {
			DBUtil.closeConnection(ps, connection);
		}
	}
	
}
