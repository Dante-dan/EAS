package com.dante.studentmanage.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.UserDao;
import com.dante.studentmanage.entity.User;

public class GetByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetByUidServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/***
		 * 从数据库中按id获取user并利用request传回jsp
		 */
		int uid =Integer.parseInt(request.getParameter("id"));
		UserDao userDao = new UserDao();
		User user = new User();
		user = userDao.getByID(uid);
		request.setAttribute("user", user);
		request.getRequestDispatcher("../user/modifyuser.jsp").forward(request, response);
	}

}
