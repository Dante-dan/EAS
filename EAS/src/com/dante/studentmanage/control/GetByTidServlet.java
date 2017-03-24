package com.dante.studentmanage.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.TeacherDao;
import com.dante.studentmanage.entity.Teacher;
/**
 * 通过id获取教师
 * @author 63434
 *
 */
public class GetByTidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetByTidServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.getById(Integer.parseInt(id));
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("../teacher/modifyteacher.jsp").forward(request, response);
	}

}
