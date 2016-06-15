<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show Product</title>
	</head>
<body>
	<h1>Newly created Product Info : </h1>
	<table>
		<tbody>
			<tr>
				<td>Product Name</td>
				<td>&nbsp;&nbsp;</td>
				<td>${product.name}</td>
			</tr>
			
			<tr>
				<td>Price</td>
				<td>&nbsp;&nbsp;</td>
				<td>${product.price}</td>
			</tr>
			
			<tr>
				<td>Product Name</td>
				<td>&nbsp;&nbsp;</td>
				<td>${product.description}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>