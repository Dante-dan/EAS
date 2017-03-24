<%@page import="com.dante.studentmanage.dao.CourseDao"%>
<%@page import="com.dante.studentmanage.entity.Course"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入BootStrap文件 -->
<link href="//cdn.bootcss.com/bootstrap/3.0.2/css/bootstrap.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.2/js/bootstrap.js"></script>
<style type="text/css">
.form-control {
	width: 250px;
}

form {
	width: 80%;
	padding-top: 40px;
	padding-bottom: 10px;
	padding-left: 30%;
	padding-right: 30%;
}
</style>
<script type="text/javascript">
	function confirmDel() {
		if (confirm("确定删除")) {
			return true;
		} else {
			return false;
		}
	}
	
</script>

</head>
<body>

	<div class="table-responsive">
		<table class="table">
			<caption>已选课程管理</caption>
			<thead>
				<tr>
					<th>编号</th>
					<th>课程名称</th>
					<th>容纳人数</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
				<%
				int sid = Integer.parseInt(session.getAttribute("sid").toString());
				Course course = new Course();
				CourseDao courseDao = new CourseDao();
				List<Course> list = courseDao.getBySid(sid);
				Iterator iterator = list.iterator();
				while(iterator.hasNext()){
					course = (Course)iterator.next();
				%>
				<tr>
					<td><%=course.getCid() %> </td>
					<td><%=course.getName() %> </td>
					<td><%=course.getVolume() %>  </td>
					<td><%=course.getTime() %> </td>
				<%} %>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>