<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改教师信息</title>
<!-- 引入bootstrap文件 -->
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
	<form role="form" action="../teacher/modifyTeacherServlet">
		<div class="form-group">
			<label for="nickname">昵称不可修改</label><input class="form-control"
				id="nickname" name="nickname" type="hidden"  value="${teacher.nickname }"
				placeholder="请输入昵称" />
		</div>
		<div class="form-group">
			<label for="realname">姓名</label><input class="form-control"
				id="realname" name="realname" type="text" value="${teacher.realname }" 
				placeholder="请输入真实姓名"/>
		</div>
		<!-- ================专业下拉选择框=============== -->
		<div>
			<label>专业</label> <select class="form-control input-lg" name="major">
				<option <c:if test="${student.major=='web前端' }">selected</c:if>>web前端</option>
				<option <c:if test="${student.major=='javaweb' }">selected</c:if>>javaweb</option>
				<option <c:if test="${student.major=='PHP' }">selected</c:if>>PHP</option>
				<option <c:if test="${student.major=='Linux' }">selected</c:if>>Linux</option>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleInputFile">选择照片</label><input
				id="exampleInputFile" type="file" />
			<p class="help-block">请选择本地头像文件</p>
		</div>
		<div class="col-md-6 column">
			<input type="hidden" name="id" value="${teacher.tid }">
			<button type="submit" class="btn btn-default">确认修改</button>
		</div>
</body>
</html>