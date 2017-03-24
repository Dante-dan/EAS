package com.dante.studentmanage.entity;
/**
*@author: Dante
*@version: 2017年3月17日下午12:41:22
*
**/
public class Course {
	private int cid;
	private String name;
	private int volume;
	private String time;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
