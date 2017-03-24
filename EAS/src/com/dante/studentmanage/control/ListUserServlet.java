package com.dante.studentmanage.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.UserDao;
import com.dante.studentmanage.entity.User;

public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		UserDao userDao = new UserDao();
		List<User> list = userDao.getAll();
		request.setAttribute("list_user", list);
		request.getRequestDispatcher("../user/listuser.jsp").forward(request, response);
		
	}

}
