package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoAddCS extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DoAddCS() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		request.getSession().setAttribute("sid", sid);
		request.setAttribute("sid", sid);
		request.getRequestDispatcher("../cs/doaddcs.jsp").forward(request, response);
	}

}
