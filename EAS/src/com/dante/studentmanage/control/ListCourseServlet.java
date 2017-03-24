package com.dante.studentmanage.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CourseDao;

public class ListCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDao courseDao = new CourseDao();
		List<Map<Integer, String>> list = courseDao.getAll();
		request.setAttribute("list_course_teacher", list);
		request.getRequestDispatcher("../course/listcourse.jsp").forward(request, response);

	}

}
