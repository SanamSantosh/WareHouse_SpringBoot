<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.WareHouseManagement.demo.Bean.CustomerInfo"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Customer Information</title>
</head>
<body align="center">
  <%@include file="CustomerCheck.jsp" %>
<h1>Customer Details</h1>
        	<%
        	CustomerInfo custObj=(CustomerInfo)request.getAttribute("obj");
        	%>
        	<% if(custObj!=null) {%>
        	<table border="1" align="center">
        	<tr><td>Customer Name:</td><td><input type="text" value=<%=custObj.getName() %> readonly></td></tr>
        	<tr><td>Phone Number:</td><td><input type="text" value=<%=custObj.getPhonenumber() %> readonly></td></tr>
        	<tr><td>Address:</td><td><input type="text" value=<%=custObj.getAdderss() %> readonly></td></tr>
        	</table>
        	<%} %>
  <br><br>
  <a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>

</body>
</html>