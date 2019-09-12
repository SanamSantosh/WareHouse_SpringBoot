<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.WareHouseManagement.demo.Bean.*"
	import="java.util.List" import="com.WareHouseManagement.demo.Service.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta charset="UTF-8">
<title>Orders</title>
</head>
<%
	
%>
<body style="text-align: center">
	<h3>Order Details</h3>
	<%
		String Accept = "accept";
		String Reject = "reject";
		List<PurchaseDetails> list1 = (List<PurchaseDetails>) request.getAttribute("obj");
		List<MerchantStock> list = (List<MerchantStock>) request.getAttribute("obj1");
	%>
	<div style="overflow: auto; height: 180px;">
		<table border="1" align="center">
			<tr>
				<td>Stock Id</td>
				<td>Item Id</td>
				<td>Item Name</td>
				<td>Merchant Id</td>
				<td>Merchant Name</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>Stock</td>
			</tr>

			<%
				System.out.println("printing");
				if (list1 != null) {
					for (PurchaseDetails details : list1) {
						for (MerchantStock merchant : list) {
							if (details.getMerchantObj().getStock_id() == merchant.getStock_id()) {
								;
			%>

			<tr>
				<td><input type="text" value=<%=merchant.getStock_id()%>
					readonly></td>
				<td><input type="text"
					value=<%=merchant.getItemObj().getItem_id()%> readonly></td>
				<td><input type="text"
					value=<%=merchant.getItemObj().getName()%> readonly></td>
				<td><input type="text"
					value=<%=merchant.getMerchantObj().getMerchant_id()%> readonly></td>
				<td><input type="text"
					value=<%=merchant.getMerchantObj().getName()%> readonly></td>
				<td><input type="text" value=<%=merchant.getPrice()%> readonly></td>
				<td><input type="text" value=<%=details.getQuantity()%>
					readonly></td>
				<td><input type="text" value=<%=merchant.getStock()%> readonly></td>
				<td><a
					href="orderactioncontrol?action=<%=Accept%>&purchaseid=<%=details.getPurchase_id()%>"><input
						type="button" name="name" value="Accept"></a></td>
				<td><a
					href="orderactioncontrol?action=<%=Reject%>&purchaseid=<%=details.getPurchase_id()%>"><input
						type="button" name="name" value="Reject"></a></td>
			</tr>

			<%
				}
						}
					}
				} else {
					out.println("<h3>No Orders</h3>");
					System.out.println("no orders");
				}
			%>

		</table>
	</div>
	<a href="MerchantLogin.jsp"><input type="button" name="button"
		value="Logout"></a>
	<a href="MerchantHomePage.jsp"><input type="button" name="button"
		value="Back"></a>

	<br>
	<br>
</body>
</html>