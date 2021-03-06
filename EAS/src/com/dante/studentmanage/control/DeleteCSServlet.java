package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CSDao;

public class DeleteCSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCSServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CSDao csDao = new CSDao();
		int cid = Integer.parseInt(request.getParameter("cid"));
		int sid = Integer.parseInt((String)request.getSession().getAttribute("sid"));
		csDao.deleteCS(cid, sid);
	}

}
