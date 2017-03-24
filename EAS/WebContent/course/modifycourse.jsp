<%@page import="com.dante.studentmanage.dao.CTDao"%>
<%@page import="com.dante.studentmanage.entity.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.dante.studentmanage.dao.TeacherDao"%>
<%@page import="com.dante.studentmanage.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户信息</title>
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
form{
	width: 80%;
	padding-top: 40px;
	padding-bottom: 10px;
	padding-left: 30%;
	padding-right: 30%;
}
</style>
<script type="text/javascript">
	$(function(){
		if($("#message").text()!=""){
			$("#error").delay(2000).hide(0);
		}
	});
	function check(){
		if(document.getElementById("name").valueOf().value==""){
			alert("请输入课程名");
			document.forms.course_form.name.focus();
			return false;
		}if(document.getElementById("volume").valueOf().value==""){
			alert("请输入课程人数");
			document.forms.course_form.volume.focus();
			return false;
		}if(document.getElementById("time").valueOf().value==""){
			alert("请输入上课时间");
			document.forms.course_form.time.focus();
			return false;
		}
	}
</script>
</head>
<body>
<% 
	Course course = (Course)request.getAttribute("course");
	TeacherDao teacherDao = new TeacherDao();
	CTDao ctDao = new CTDao();
%>
	<div class="container">
		<form role="form" action="../course/modifyCourseServlet?cid=${course.cid }" name="course_form">
			<div class="form-group">
				<label for="name">课程名</label>
				<input class="form-control" id="name" name="name" type="text" value="${course.name }" placeholder="请输入课程名" />
			</div>
			<div class="form-group">
				<label for="volume">课程人数</label><input class="form-control"
					id="volume" name="volume" type="text" value="${course.volume }" placeholder="请输入上课人数"/>
			</div>
			<div class="form-group">
				<label for="volume">上课时间</label><input class="form-control"
					id="time" name="time" type="time" value="${course.time } placeholder="请选择上课时间"/>
			</div>
			<div>
			<label>授课老师</label> <select class="form-control input-lg" name="teacher">
			<%
				Teacher	teacher=teacherDao.getById(ctDao.getTidByCid(course.getCid()));
			%>
				<option value="<%= teacher.getTid()%>"><%= teacher.getRealname()%></option>
				
			
			</select>
		</div>
		<div id="error" style="color: red; padding: 0; margin: 0;">
					<p id="message">
						${requestScope.error1}
					</p>
				</div>
				<div class="col-md-6 column">
						<button type="submit" class="btn btn-default" onclick="return check(this)">添加</button>
				</div>
		</form>
	</div>
</body>
</html>