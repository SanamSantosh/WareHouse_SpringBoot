<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Stock Purchase page</title>
</head>
<body style="text-align: center">
	<h3>Purchase Stock</h3>
	<form name="index" style="text-align: center" method="post"
		action="purchasecontrol">
		<table border="1" align="center">
			<tr>
				<td>Stock Id:</td>
				<td><input type="text" name="stockid" value="" required></td>
			</tr>
			<tr>
				<td>Merchant Id:</td>
				<td><input type="text" name="merchantid" value="" required></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><input type="text" name="quantity" value="" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
			<tr>
		</table>
		<a href="Home.jsp"><input type="button" name="button" value="back"></a>
		<a href="Login.jsp"><input type="button" name="button"
			value="logout"></a>
	</form>
</body>
</html>