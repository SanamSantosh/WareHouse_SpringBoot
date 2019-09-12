<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Check Item Page</title>
</head>
<body>
	<form name="index" style="text-align: center" method="post"
		action="iteminfocontrol">
		<h3>Item Information Page</h3>
		<p>
			Item ID:<input type="text" name="item_id" value="" required>
		</p>
		<input type="submit" name="index_validate" value="submit"> <a
			href="ItemDetails.jsp"><input type="button" name="button"
			value="Back"></a> <a href="Login.jsp"><input type="button"
			name="button" value="Logout"></a>
	</form>
</body>
</html>