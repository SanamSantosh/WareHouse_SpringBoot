<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.WareHouseManagement.demo.Bean.*"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head >

<meta charset="UTF-8">
<title>Merchant Details</title>
</head>


<body style="text-align:center">
<h3 style="color:blue">Merchant Details</h3>
<%
List<MerchantStock> list = (List<MerchantStock>)request.getAttribute("obj");
%>
<div style="overflow: auto;height: 180px;">
<table border="1" align="center">
<tr><td>Stock Id</td><td>Item Id</td><td>Item Name</td><td>Merchant Id</td><td>Merchant Name</td><td>Price</td><td>Stock</td></tr>

<% 
for(MerchantStock merchantStock:list){ %>

<tr><td><input type="text" value=<%=merchantStock.getStock_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getItemObj().getItem_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getItemObj().getName()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getMerchantObj().getMerchant_id()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getMerchantObj().getName()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getPrice()%> readonly></td>
<td><input type="text" value=<%=merchantStock.getStock()%> readonly></td></tr>

<% }%>

</table>
</div> 

<br><br>
<%@include file="PurchaseStock.jsp" %>
</body>
</html>