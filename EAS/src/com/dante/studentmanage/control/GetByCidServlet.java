package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CourseDao;
import com.dante.studentmanage.entity.Course;

public class GetByCidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetByCidServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String a = request.getParameter("id");
		int cid = Integer.parseInt(request.getParameter("id"));
		System.out.println(a);
		CourseDao courseDao = new CourseDao();
		Course course = new Course();
		course = courseDao.getByID(cid);
		request.setAttribute("course", course);
		request.getRequestDispatcher("../course/modifycourse.jsp").forward(request, response);
	}

}
