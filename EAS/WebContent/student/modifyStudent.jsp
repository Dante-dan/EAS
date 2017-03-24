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
	
	<form role="form" action="../student/modifyStudentServlet" method="post">
		<div class="form-group">
			<label for="nickname">昵称</label> <input type="text"
				value="${student.nickname }" class="form-control"
				name="nickname" placeholder="请输入昵称">
		</div>
		<div class="form-group">
			<label for="realname">真实姓名</label> <input type="text"
				value="${student.realname }" class="form-control"
				name="realname" placeholder="请输入真实姓名">
		</div>
		<!--==============性别单选框 ==================== -->
		<label>性别</label>
		<div class="checkbox-inline">
			<label> <input type="radio" name="gender" value="man"
				<c:if test="${student.gender=='man'}">checked</c:if>>男
			</label>
		</div>
		<div class="checkbox-inline">
			<label> <input type="radio" name="gender" value="woman"
				<c:if test="${student.gender=='woman' }">checked</c:if>>女
			</label>
		</div>
		<div class="form-group">
			<label for="realname">出生日期</label> <input type="date"
				value="${student.birthday }" class="form-control"
				name="birthday" placeholder="输入固定格式，例如：2016-10-10">
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
		<!-- ================兴趣复选框=============== -->
		<div>
			<label>兴趣</label> <label class="checkbox-inline">
			<c:set value="${student.interests }" var="c"></c:set>
			 <input
				type="checkbox" name="interest" value="看电影"
				<c:if test="${fn:contains(c,'看电影') }">checked </c:if> >看电影
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="读书" name="interest"
				<c:if test="${fn:contains(c,'读书') }">checked </c:if> >读书
			</label> <label class="checkbox-inline"> <input type="checkbox"
				value="听音乐" name="interest"
				<c:if test="${fn:contains(c,'听音乐') }">checked </c:if> >听音乐
			</label>
			<div>
				<label>备注</label>
				<textarea class="form-control" name="remark" rows="3">${student.remark }</textarea>
			</div>
			<div>
				<input type="hidden" name="id" value="${student.sid }">
				<button type="submit" class="btn btn-default">提交</button>
			</div>
		</div>
	</form>
</body>
</html>