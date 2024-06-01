<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Bill Details</h1>
<hr>
<h2 align="right">${user.getName() }	|
<a href="logout">Log out</a>
</h2>
<hr>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Price</th></tr>
<c:forEach var="b" items="${list }"> 
<tr>
<td>${b.getItemname() }</td>
<td>${b.getPrice() }</td>
</tr>
</c:forEach>
	</table>
	
	<h2 align="center">Total Amount : ${price } </h2>
<h2 align="center">  
<a href="confirm">confirm Order</a>
</h2>
</body>
</html>