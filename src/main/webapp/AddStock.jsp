<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Add Stock Page</title>
</head>
<body>
	<form name="index" style="text-align: center" method="post"
		action="addStock">
		<h3>Add Stock</h3>
		<table border="1" align="center">
			<tr>
				<td>Stock:</td>
				<td><input type="text" name="stock" value="" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="index_validate" value="submit"></td>
			</tr>
			<tr>
		</table>
		<a href="ItemDetails.jsp"><input type="button" name="button"
			value="back"></a> <a href="Login.jsp"><input type="button"
			name="button" value="logout"></a>
	</form>
</body>
</html>