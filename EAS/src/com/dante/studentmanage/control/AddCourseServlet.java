package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CTDao;
import com.dante.studentmanage.dao.CourseDao;
import com.dante.studentmanage.entity.Course;
import com.sun.xml.internal.ws.streaming.TidyXMLStreamReader;

public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Course course = new Course();
		CTDao ctDao = new CTDao();
		if(request.getParameter("name").equals("")||request.getParameter("name")==null||
				request.getParameter("volume").equals("")||request.getParameter("volume")==null||
				request.getParameter("time").equals("")||request.getParameter("time")==null){
			//request.setAttribute("error1", "请正确输入课程名，人数及时间相关信息");
			request.getRequestDispatcher("../course/addcourse.jsp").forward(request, response);
		}
		else{

		 String str = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");  
		String a = request.getParameter("name");
		course.setName(request.getParameter("name"));
		course.setVolume(Integer.parseInt(request.getParameter("volume")));
		course.setTime(request.getParameter("time"));
		int tid = 0;
		if (request.getParameter("id").isEmpty()) {
			tid=Integer.parseInt(request.getParameter("teacher"));
		}else{
			tid=Integer.parseInt(request.getParameter("id"));
		}
		
		request.setAttribute("tid", tid);
		request.setAttribute("id", tid);
		int cid=0;
		CourseDao courseDao = new CourseDao();
		CourseDao courseDao2 = new CourseDao();
		if (courseDao.addCourse(course)) {
			cid = courseDao2.getCid(course);
		}
		ctDao.addCT(cid, tid);
		}
		request.getRequestDispatcher("../course/getCourseByTidServlet").forward(request, response);
	}

}
