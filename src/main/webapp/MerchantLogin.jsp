<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Merchant Login Page</title>
</head>
<body>
	<form name="index" style="text-align: center" method="post"
		action="merchantlogincontrol">
		<h3>Login</h3>
		<table border="1" align="center">
			<tr>
				<td>Merchant Id:</td>
				<td><input type="text" name="merchant_id" value="" required></td>
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
		<a href="Login.jsp"><input type="button" name="name"
			value="WareHouseLogin"></a>
	</form>
</body>
</html>