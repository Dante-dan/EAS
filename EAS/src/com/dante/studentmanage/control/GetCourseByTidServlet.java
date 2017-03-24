package com.dante.studentmanage.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CourseDao;
import com.dante.studentmanage.dao.TeacherDao;
import com.dante.studentmanage.entity.Course;
import com.dante.studentmanage.entity.Teacher;

public class GetCourseByTidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCourseByTidServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Course course = new Course();
		CourseDao courseDao = new CourseDao();
		Teacher teacher = new Teacher();
		TeacherDao teacherDao = new TeacherDao();
		Integer  tid = (Integer)request.getAttribute("tid");
		Integer coursedId = (Integer)request.getAttribute("id");
		
		List<Map<Integer, String>>  list = new ArrayList<Map<Integer, String>>();
		if (request.getParameter("id").isEmpty()) {
			list = courseDao.getAll(tid);
			
		}else {
//			list = courseDao.getAll((Integer.parseInt(String.valueOf(request.getAttribute("id")))));
			list = courseDao.getAll(Integer.parseInt(request.getParameter("id")));		
			}
		
//		teacher = teacherDao.getById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("list_course_teacher", list);
//		request.setAttribute("teacher_course", teacher);
		request.getRequestDispatcher("../course/listcourse.jsp").forward(request, response);
	}

}
