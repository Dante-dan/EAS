<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.dante.studentmanage.dao.CourseDao"%>
<%@page import="com.dante.studentmanage.entity.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css"
	rel="stylesheet">
<style type="text/css">
body {
	padding-top: 10px;
	padding-bottom: 40px;
	padding-left: 80px;
	padding-right: 80px;
}

form {
	width: 80%;
	padding-top: 10px;
	padding-bottom: 40px;
	padding-left: 80px;
	padding-right: 80px;
}
</style>
</head>
<body>
<% 	
	CourseDao courseDao = new CourseDao();
	CourseDao courseDao2 = new CourseDao();
	int s_id = Integer.parseInt(request.getAttribute("sid").toString());
	List<Map<Integer,String>> list_all = courseDao2.getAll();
	Iterator<Map<Integer,String>> iterator_all = list_all.iterator();
	session.setAttribute("sid", s_id);
	List<Course> list = courseDao.getBySid(s_id);
%>
	
	<form role="form" action="../cs/addCSServlet" method="post">
		<!-- ================课程多选下拉框=============== -->
		<div>
			<label>选择课程</label> <select multiple class="form-control" size="5"
				name="course">
				<% while(iterator_all.hasNext()){
					Map map = (Map)iterator_all.next();
					Iterator<Course> iterator = list.iterator();
				%>
				<option  value="<%=map.get(1)%>" <%
				for(int i = 0; i<list.size();i++){
					Course course = new Course();
					course=list.get(i) ;
					if(course.getName().equals(map.get(2))){
					%>disabled="disabled" <%}}%>><%=map.get(2) %></option>
				<%} %>
			</select>
		</div>
		
			<div>
				<button type="submit" class="btn btn-default">提交</button>
			</div>
		</div>
	</form>
</body>
</html>