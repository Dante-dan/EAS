package com.dante.studentmanage.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.CSDao;
import com.dante.studentmanage.dao.CourseDao;
import com.dante.studentmanage.dao.StudentDao;
import com.dante.studentmanage.entity.Course;
import com.dante.studentmanage.entity.Student;
/**
 * 通过id获取学生
 * @author 63434
 *
 */
public class GetBySidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBySidServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getByID(Integer.parseInt(id));
//		CourseDao courseDao = new CourseDao();
//		List<Course> list_course = courseDao.getBySid(Integer.parseInt(id));
		request.setAttribute("student", student);
//		request.getSession().setAttribute("list_course", list_course);
		request.getRequestDispatcher("../student/modifyStudent.jsp").forward(request, response);
	}

}
