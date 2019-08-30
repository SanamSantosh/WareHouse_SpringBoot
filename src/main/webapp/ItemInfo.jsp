<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.WareHouseManagement.demo.Bean.ItemInfo"
    import="java.lang.Math"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Info Page</title>
</head>
<body align="center">

  <%@include file="CheckItem.jsp" %>
<h1 style="color:blue">Item Details</h1>
        	<%
        	ItemInfo itemInfoObj=(ItemInfo)request.getAttribute("obj");
        	int discount=(int)request.getAttribute("obj1");
        	%>
        	<table border="1" align="center">
        	<tr><td>Item Name:</td><td><input type="text" value=<%=itemInfoObj.getName()%> readonly></td></tr>
        	<tr><td>Price:</td><td><input type="text" value=<%=itemInfoObj.getPrice()%> readonly></td></tr>
        	<tr><td>Price After Discount:</td><td><input type="text" value=<%=discount%> readonly></td></tr>
        	<tr><td>Stock:</td><td><input type="text" value=<%=itemInfoObj.getStock()%> readonly></td></tr>
        	</table>
  <br><br>
  <a href="ItemDetails.jsp"><input type="button" name="button" value="Back"></a>
  <a href="Login.jsp"><input type="button" name="button" value="Logout"></a>
</body>
</html>