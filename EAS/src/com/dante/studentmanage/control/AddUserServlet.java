package com.dante.studentmanage.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.UserDao;
import com.dante.studentmanage.entity.User;

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername((String) request.getParameter("username"));
		user.setPassword((String) request.getParameter("password"));
		user.setAuthor((String) request.getParameter("author"));
		if (userDao.check(user.getUsername())) {
			userDao.addUser(user);
			response.sendRedirect("../user/ListUserServlet");
		}else{
			request.setAttribute("error", "用户名重复，请重新输入");
			request.getRequestDispatcher("../user/adduser.jsp").forward(request, response);
		}
		
	}

}
