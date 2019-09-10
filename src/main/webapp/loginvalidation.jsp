<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
        	String msg=(String)request.getAttribute("obj");
        	%>
        	<p> <%=msg %></p>
        	<a href="Login.jsp"><input type="button" name="button" value="back"></a>
</body>
</html>