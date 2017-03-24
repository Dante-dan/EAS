<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl（javascript标准标签库) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息管理</title>
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
					<th>UID</th>
					<th>用户名</th>
					<th>身份</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list_user }" var="user">

					<tr>
						<td>${user.id }</td>
						<td>${user.username }</td>
						<c:if test="${user.author =='0'}">
							<td>管理员</td>
						</c:if>
						<c:if test="${user.author =='1'}">
							<td>教师</td>
						</c:if>
						<c:if test="${user.author =='2'}">
							<td>学生</td>
						</c:if>
						<td><a href="../user/getByUidServlet?id=${user.id }">
						<button type="button" class="btn btn-default">修改</button></a></td>
						<td> <a href="../user/deleteUserServlet?id=${user.id }"
							onclick="return confirmDel()">
						<button type="button" class="btn btn-default">删除</button></a></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>