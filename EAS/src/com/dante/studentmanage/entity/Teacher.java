package com.dante.studentmanage.entity;


/**
*@author: Dante
*@version: 2017年3月16日下午5:08:34
*
**/
public class Teacher {

	private int uid;
	private int tid;
	private String nickname;
	private String realname;
	private String major;
//	private String course[] = { "" };
//	private String courses = "";
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
/*	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public String getCourses() {
		if (course != null) {
			for (int i = 0; i < course.length; i++) {
				courses += course[i] + "\t";
			}
		}
		// courses=courses.substring(0, course.length-1);
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	*/
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Teacher [uid=" + uid + ", tid=" + tid + ", nickname=" + nickname + ", realname=" + realname + ", major="
				+ major + "]";
	}
	
	
}
