<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

<link rel="stylesheet" type="text/css" href="../css/login.css">
<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.username.value == "") {
			alert("请输入用户名");
			document.forms.loginForm.username.focus();
			return false;
		}
		if (document.forms.loginForm.password.value == "") {
			alert("请输入密码");
			document.forms.loginForm.password.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form action="../user/LoginServlet" method="post" name="loginForm">
		<div class="login_m">
			<div class="login_logo" width="220px" heigh="50px">
				<img src="../img/logo.png">
			</div>
			<div class="login_border">
				<B>用户名：</B> <input type="text" name="username" class="text_input2">
				<br> <br> <B>密码：</B><input type="password" name="password"
					class="text_input"> <br> <br>
				<div>
					<input type="submit" value="登录" class="button1"
						onclick="return check(this);">
				</div>
				<div style="color: red; padding: 0; margin: 0;">
					<p>
						${requestScope.error}
					</p>
				</div>
			</div>

		</div>
	</form>
</body>
</html>