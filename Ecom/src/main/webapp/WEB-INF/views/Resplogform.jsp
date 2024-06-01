<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Login Successfully</h1>
<hr>
<h2 align="right">${key.getName() } </h2>
<h3 align="right">
<a href="card">My card</a>	|
<a href="logout">Log out</a>
</h3>
<hr>

<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Price</th><th>Add to Card</th></tr>
<c:forEach var="b" items="${item }"> 
<tr>

<td>${b.getItemname() }</td>
<td>${b.getPrice() }</td>

<td> <a href="/addCard/${b.getId() }">Add to Card </a> </td>
</tr>
</c:forEach>
	</table>
</body>
</html>