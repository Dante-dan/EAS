package com.dante.studentmanage.entity;

import java.util.Arrays;

/**
 * @author: Dante
 * @version: 2017年3月6日下午7:34:31
 *
 **/
public class Student {
	private int sid;
	private int uid;
	private String nickname;
	private String realname;
	private String gender;
	private String birthday;
	private String major;
//	private String course[] = { "" };
//	private String courses = "";
	private String interest[] = { "" };
	private String interests = "";
	private String remark;


	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

/*
	 * public String[] getCourse() {
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
	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	public String getInterests() {
		if (interest != null) {
			for (int i = 0; i < interest.length; i++) {
				interests += interest[i] + "\t";
			}
		}
		// interests=interests.substring(0,interest.length-1);
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", nickname=" + nickname + ", realname=" + realname + ", gender=" + gender
				+ ", birthday=" + birthday + ", major=" + major + ", course="  + ", courses="
				+ ", interest=" + Arrays.toString(interest) + ", interests=" + interests + ", remark="
				+ remark + "]";
	}

}
