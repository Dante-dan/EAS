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
</head>
<body>
	<div class="container">
		<form role="form" action="../user/AddUserServlet">
			<div class="form-group">
				<label for="username" >用户名</label><input class="form-control"
					id="username" name="username" type="text" placeholder="请输入用户名" />
			</div>
			<div class="form-group">
				<label for="password">密码</label><input class="form-control"
					id="password" name="password" type="password" placeholder="请输入密码"/>
			</div>
			<div class="form-group">
				<label for="exampleInputFile">选择照片</label><input
					id="exampleInputFile" type="file" />
				<p class="help-block">请选择本地头像文件</p>
			</div>
			<div class="form-group">
			<label for="author" >请选择当前用户权限</label>
			</div>
			<div class="checkbox">
				<label><input type="radio" value="2" id="author" name="author" checked="checked"/>学生</label>
				<br>
				<br>
				<label><input type="radio" value="1" id="author" name="author"/>老师</label>
				</div>
				<div style="color: red; padding: 0; margin: 0;">
					<p>
						${requestScope.error}
					</p>
				</div>
				<div class="col-md-6 column">
						<button type="submit" class="btn btn-default">添加</button>
				</div>
		</form>
	</div>
</body>
</html>