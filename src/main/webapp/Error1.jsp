<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<%
        	String msg=(String)request.getAttribute("obj");
String msg1=(String)request.getAttribute("obj1");
        	%>
        	<p> <%=msg %></p>
        	<p> <%=msg1 %></p>
        	<a href="MerchantHomePage.jsp"><input type="button" name="button" value="back"></a>
</body>
</html>