
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
	
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-10 column">
				<img alt="140x140" src="../img/logo.png" />
			</div>
			<div class="col-md-2 column">
				<p>欢迎您!${teacher.nickname }</p>			
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="">主页</a></li>

				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="">主页</a>
						</h3>
					</div>
					<div class="panel-body">
						<a href="../teacher/listteacher.jsp" target="main">教师信息管理</a>
					</div>
					<div class="panel-footer">
						<a href="../course/addcoursebyt.jsp"  target="main">添加课程</a>
					</div>
					<div class="panel-footer">
						<a href="../user/LogoutServlet">退出</a>
					</div>
				</div>
			</div>
			<div class="col-md-9 column">
				<iframe frameborder="1" name="main" src="../login/center.html" height="500px"
					width="100%"></iframe>
			</div>
		</div>
	</div>
</body>
</html>