<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form name="index" style="text-align: center" method="post"
		action="logincontrol">
		<h3>Login</h3>
		<table border="1" align="center">
			<tr>
				<td>Login Id:</td>
				<td><input type="text" name="login_id" value="" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value="" required></td>
			</tr>
			<tr>
				<td><input type="reset" name="index_clear" value="Clear"></td>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
		</table>
		<a href="MerchantLogin.jsp"><input type="button" name="name"
			value="MerchantLogin"></a>
	</form>
</body>
</html>