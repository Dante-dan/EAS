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
	
	<form role="form" action="../cs/doAddCS" method="post">
		
		<!-- ================学生下拉选择框=============== -->
		<div>
			<label>请选择需要选课的学生</label> 
			<select class="form-control input-lg" name="sid">
			<c:forEach items="${list }" var="student">
				<option value="${student.sid }">${student.realname }</option>
			</c:forEach>
			</select>
		</div>
		
			<div>
				<button type="submit" class="btn btn-default">提交</button>
			</div>
	</form>
</body>
</html>