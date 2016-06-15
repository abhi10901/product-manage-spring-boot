<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Product</title>
</head>
<body>

	<h1><fmt:message key="title.addProduct"/></h1>
	<f:form action="/product/create" method="POST" commandName="product">
		<table>
			<tbody>
				<tr>
					<td><f:label path="name"><fmt:message key="product.name" /></f:label></td>
					<td>&nbsp;&nbsp;</td>
					<td><f:input path="name"/></td>
					<td><f:errors path="name" cssClass="error"/></td>
				</tr>
				
				<tr>
					<td><f:label path="price"><fmt:message key="product.price" /></f:label></td>
					<td>&nbsp;&nbsp;</td>
					<td><f:input path="price"/></td>
					<td><f:errors path="price" cssClass="error"/></td>
				</tr>
				
				<tr>
					<td><f:label path="description"><fmt:message key="product.description" /></f:label></td>
					<td>&nbsp;&nbsp;</td>
					<td><f:textarea path="description"/></td>
				</tr>
				
				<tr>
					<td><input type="button" name="cancel" value="<fmt:message key='form.cancel'/>" onclick="window.location = '/product/'"/></td>
					<td>&nbsp;&nbsp;</td>
					<td><input type="submit" name="productSave" value="<fmt:message key='form.submit'/>"/></td>
				</tr>
			</tbody>
		</table>
	</f:form>
</body>
</html>