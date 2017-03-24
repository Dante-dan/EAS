package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CourseDao;
import com.dante.studentmanage.entity.Course;
public class ModifyCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CourseDao courseDao = new CourseDao();
		Course course = new Course();
		course.setCid(Integer.parseInt(request.getParameter("cid")));
		course.setName(request.getParameter("name"));
		course.setVolume(Integer.parseInt(request.getParameter("volume")));
		course.setTime(request.getParameter("time"));
		courseDao.changeCourse(course);
		request.getRequestDispatcher("../course/listCourseServlet").forward(request, response);
	}

}
