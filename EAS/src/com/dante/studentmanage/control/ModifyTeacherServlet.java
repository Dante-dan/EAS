package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.TeacherDao;
import com.dante.studentmanage.entity.Teacher;

public class ModifyTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModifyTeacherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = new Teacher();
		TeacherDao teacherDao = new TeacherDao();
		String idString = request.getParameter("id");
		teacher.setTid(Integer.parseInt(request.getParameter("id")));
		teacher.setNickname(request.getParameter("nickname"));
		teacher.setRealname(request.getParameter("realname"));
		teacher.setMajor(request.getParameter("major"));
		teacherDao.changeTeacher(teacher);
		request.getRequestDispatcher("../user/LoginServlet").forward(request, response);
	}

}
