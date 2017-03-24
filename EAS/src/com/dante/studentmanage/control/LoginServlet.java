package com.dante.studentmanage.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.StudentDao;
import com.dante.studentmanage.dao.TeacherDao;
import com.dante.studentmanage.dao.UserDao;
import com.dante.studentmanage.entity.Student;
import com.dante.studentmanage.entity.Teacher;
import com.dante.studentmanage.entity.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		Student student = new Student();
		Teacher teacher = new Teacher();
		user.setUsername(username);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		TeacherDao teacherDao = new TeacherDao();
		StudentDao studentDao = new StudentDao();
		if(userDao.validate(user)==0){
			request.getSession().setAttribute("user",user);
			response.sendRedirect("../login/main.jsp");
			
		}else if(userDao.validate(user)==1){
			int tid = userDao.getTidByUsername(username);
			teacher = teacherDao.getById(tid);
			request.getSession().setAttribute("teacher", teacher);
			List<Teacher> list = new ArrayList<Teacher>();
			list.add(teacher);
			request.getSession().setAttribute("list_teacher", list);
			request.getRequestDispatcher("../teacher/main_t.jsp").forward(request, response);
		}else if(userDao.validate(user)==2){
			int sid = userDao.getSidByUsername(username);
			student = studentDao.getByID(sid);
			request.getSession().setAttribute("student", student);
			request.getSession().setAttribute("sid", sid);
			List<Student> list = new ArrayList<Student>();
			list.add(student);
			request.getSession().setAttribute("list", list);
			request.getRequestDispatcher("../student/main_s.jsp").forward(request, response);
		}
		else{
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("../login/login.jsp").forward(request, response);
		}
	}

}
