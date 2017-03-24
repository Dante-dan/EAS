<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>

	<div class="table-responsive">
		<table class="table">
			<caption>教师信息管理</caption>
			<thead>
				<tr>
					<th>编号</th>
					<th>昵称</th>
					<th>姓名</th>
					<th>专业</th>
					<th>所创建的课程</th>
					<th>修改</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list_teacher }" var="teacher">

				<tr>
					<td>${teacher.tid }</td>
					<td>${teacher.nickname }</td>
					<td>${teacher.realname }</td>
					<td>${teacher.major }</td>+
					<td><a href="../course/getCourseByTidServlet?id=${teacher.tid }">查看课程</a></td>
					<td><a href="../teacher/getByTidServlet?id=${teacher.tid }">修改</a></td>
				</tr>
				</c:forEach>
</body>
</html>