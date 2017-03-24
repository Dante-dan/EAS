package com.dante.studentmanage.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.StudentDao;
import com.dante.studentmanage.dao.TeacherDao;
import com.dante.studentmanage.dao.UserDao;
import com.dante.studentmanage.entity.Teacher;
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		StudentDao studentDao = new StudentDao();
		TeacherDao teacherDao = new TeacherDao();
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (userDao.deleteUser(id)) {
			if(studentDao.deleteStudent(id)||teacherDao.deleteTeacher(id)){
			response.sendRedirect("../user/ListUserServlet");	
			}
		}else{
			response.sendRedirect("../function/error.jsp");	
		}
	}
}
