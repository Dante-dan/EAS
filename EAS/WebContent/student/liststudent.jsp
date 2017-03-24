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
			<caption>学生信息管理</caption>
			<thead>
				<tr>
					<th>编号</th>
					<th>昵称</th>
					<th>姓名</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>专业</th>
					<th>兴趣</th>
					<th>备注</th>
					<th>修改</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="student">

				<tr>
					<td>${student.sid }</td>
					<td>${student.nickname }</td>
					<td>${student.realname }</td>
					<td>${student.gender }</td>
					<td>${student.birthday }</td>
					<td>${student.major }</td>
					<td>${student.interests }</td>
					<td>${student.remark }</td>
					<td><a href="../student/getBySidServlet?id=${student.sid }">修改</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>