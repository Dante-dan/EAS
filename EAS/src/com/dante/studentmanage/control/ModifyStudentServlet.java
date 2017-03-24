package com.dante.studentmanage.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.StudentDao;
import com.dante.studentmanage.entity.Student;


public class ModifyStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student =  new Student();
		student.setSid(Integer.parseInt(request.getParameter("id")));
		student.setNickname(request.getParameter("nickname"));
		student.setRealname(request.getParameter("realname"));
		student.setGender(request.getParameter("gender"));
		student.setBirthday(request.getParameter("birthday"));
		student.setMajor(request.getParameter("major"));
		student.setRemark(request.getParameter("remark"));
		String course[]=request.getParameterValues("course");
		if (course != null) {
//			student.setCourse(course);
		}
		String interest[] = request.getParameterValues("interest");
		if(interest !=null){
			student.setInterest(interest);
		}
		StudentDao studentDao = new StudentDao();
		if(studentDao.changeStudnt(student)){
			request.getRequestDispatcher("../student/liststudent.jsp").forward(request, response);	
		}else{
			response.sendRedirect("../function/error.jsp");	
		}
	}

}
