package com.dante.studentmanage.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.StudentDao;

public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (studentDao.deleteStudent(id)) {
			response.sendRedirect("../student/ListStudentServlet");	
		}else{
			response.sendRedirect("../student/error.jsp");	
		}
	}

}
