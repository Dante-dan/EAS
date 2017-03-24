package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CSDao;
import com.dante.studentmanage.dao.CourseDao;

public class AddCSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddCSServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getSession().getAttribute("sid").toString());
		String course[] = request.getParameterValues("course");
		CSDao csDao = new CSDao();
		if(course!=null){
			int i = 0;
			for(;i<course.length;i++){
				csDao.addCS(sid, Integer.parseInt(course[i]));
			}
		}
		request.getRequestDispatcher("../cs/listcs.jsp").forward(request, response);
	}

}
