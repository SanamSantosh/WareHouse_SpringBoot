<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.WareHouseManagement.demo.Bean.ItemInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Details Page</title>
</head>
<body align="center">

<h1 style="color:blue">Item Details</h1>
        	<%
        	ItemInfo itemInfoObj=(ItemInfo)request.getAttribute("obj");%>
        	<table border="1" align="center">
        	<tr><td>Item Name:</td><td><input type="text" value=<%=itemInfoObj.getName()%> readonly></td></tr>
        	<tr><td>Price:</td><td><input type="text" value=<%=itemInfoObj.getPrice()%> readonly></td></tr>
        	<tr><td>Stock:</td><td><input type="text" value=<%=itemInfoObj.getStock()%> readonly></td></tr>
        	</table>
  <br><br>
  
  
  <%@include file="AddStock.jsp" %>
</body>
</html>