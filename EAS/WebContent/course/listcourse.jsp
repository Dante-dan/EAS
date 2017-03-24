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
			<caption>课程信息信息管理</caption>
			<thead>
				<tr>
					<th>编号</th>
					<th>课程名称</th>
					<th>容纳人数</th>
					<th>时间</th>
					<th>授课老师</th>
					<th>修改</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Map<Integer,String>> list = (List<Map<Integer,String>>)request.getAttribute("list_course_teacher");
				Iterator iterator = list.iterator();
				while(iterator.hasNext()){
					Map map = (Map)iterator.next();
				
				%>
				<tr>
					<td><%=map.get(1) %> </td>
					<td><%=map.get(2) %> </td>
					<td><%=map.get(3) %>  </td>
					<td><%=map.get(4) %> </td>
					<td><a href="../course/getCourseByTidServlet?id=<%=map.get(6)%>"><%=map.get(5) %></a> </td>
					<td><a href="../course/getByCidServlet?id=<%=map.get(1)%>">修改</a></td>
					<td><a href="../course/deleteCourseServlet?id="<%=map.get(1) %>
						onclick="return confirmDel()">删除</a></td>
				<%} %>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>