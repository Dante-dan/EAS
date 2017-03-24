<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
<!-- 引入bootstrap文件 -->
<link href="//cdn.bootcss.com/bootstrap/3.0.2/css/bootstrap.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.0.2/js/bootstrap.js"></script>


</head>
<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					
					<a class="navbar-brand" href="main.jsp">Home</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="" class="dropdown-toggle"
							data-toggle="dropdown">管理员端<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="../user/adduser.jsp" target="main">添加用户</a></li>
								<li><a href="../user/ListUserServlet" target="main">查看用户</a></li>
							</ul></li>
						<li class="dropdown"><a href="" class="dropdown-toggle"
							data-toggle="dropdown">教师端<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="../course/addcourse.jsp" target="main">添加课程</a></li>
								<li><a href="../course/listCourseServlet" target="main">查看课程</a></li>
								<li><a href="" target="main">成绩录入</a></li>
							</ul></li>
						<li class="dropdown"><a href="" class="dropdown-toggle"
							data-toggle="dropdown">学生端<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="../student/ListStudentServlet" target="main">查看信息</a></li>
								<li><a href="../cs/addCS" target="main">选课系统</a></li>
								<li><a href="" target="main">查询成绩</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input class="form-control" type="text" />
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="">Link</a></li>
						<li class="dropdown"><a href="" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="">Action</a></li>
								<li><a href="">Another action</a></li>
								<li><a href="">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="">Separated link</a></li>
							</ul></li>
					</ul>
				</div>
				</nav>
				<!-- 文本显示框 -->
				<div class="jumbotron well" style="width: 100%;height: 500px;">
					<iframe frameborder="1" name="main" src="center.html" height="100%"
					width="100%"></iframe>
				</div>
				
				<div class="row clearfix">
					<div class="col-md-6 column">
						<button type="button" class="btn btn-default">按钮</button>
					</div>
					
				</div>
				
			</div>
		</div>
	</div>
<!------------------------------------------------ 遮蔽式窗体---------------------------------------------
				<a id="modal-68485" href="modal-container-68485" role="button"
					class="btn" data-toggle="modal">触发遮罩窗体</a>
				<div class="modal fade" id="modal-container-68485" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">确认操作</h4>
							</div>
							<div class="modal-body">确定删除UID为：${user.id }，${user.username }的相关信息吗？</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<a href="../user/deleteUserServlet?id=${user.id }">
								<button type="button" class="btn btn-primary" >确定</button></a>
							</div>
						</div>
					</div>
				</div> 
------------------------------------------------------------------------------------------------------------>
<!-- --------------------------------------------------------------------------------------------------------------
				<ul class="pagination">
					<li><a href="">Prev</a></li>
					<li><a href="">1</a></li>
					<li><a href="">2</a></li>
					<li><a href="">3</a></li>
					<li><a href="">4</a></li>
					<li><a href="">5</a></li>
					<li><a href="">Next</a></li>
				</ul>
------------------------------------------------------------------------------------------------------------------->
</body>
</html>