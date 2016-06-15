<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Products</title>
</head>
<body>
	<h1>List of All Products | <a href="/product/create">Add Product</a></h1>
	<table border="1">
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Price</th>
				<th>Description</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.description}</td>
					<td><a href="/product/edit/${product.id}">Edit</a></td>
					<td><a href="/product/delete/${product.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>