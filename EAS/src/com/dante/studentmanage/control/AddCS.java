package com.dante.studentmanage.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dante.studentmanage.dao.StudentDao;
import com.dante.studentmanage.entity.Student;

public class AddCS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCS() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao studentDao = new StudentDao();
		List<Student> list = studentDao.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("../cs/addcs.jsp").forward(request, response);
	}

}
